package com.example.runprof_task.detailsScreen.pesentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.runprof_task.R
import com.example.runprof_task.common.api.ApiState
import com.example.runprof_task.common.network.InternetStatus
import com.example.runprof_task.common.network.NetworkConnectivityObserver
import com.example.runprof_task.common.network.NetworkObservation
import com.example.runprof_task.common.util.Constant
import com.example.runprof_task.common.util.getDecimalRate
import com.example.runprof_task.databinding.FragmentDetailsBinding
import com.example.runprof_task.detailsScreen.DetailsViewModel
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/*
*** Details Fragment that responsible for observing on movie details
 */
@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val detailsViewModel: DetailsViewModel by viewModels()
    private var movieId = 0
    private lateinit var networkObservation: NetworkObservation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieId = requireArguments().getInt("movieId")
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsViewModel.getMovieDetails(movieId)
        checkNetwork()
        startObservation()
    }

   //method to observe on screen state (loading, success, failure) and handel every case
    private fun startObservation() {
        lifecycleScope.launch {
            detailsViewModel.movieDetails.collect {
                when (it) {
                    is ApiState.Loading -> {
                        hideComponents()
                        binding.detailsProgress.visibility = View.VISIBLE
                    }

                    is ApiState.Success<*> -> {
                        binding.noInternet.visibility = View.GONE
                        binding.detailsProgress.visibility = View.GONE
                        val data = it.date as? MovieDetailsResponse
                        showComponents()
                        data?.let { it1 -> setData(it1) }
                    }

                    else -> {
                        binding.detailsProgress.visibility = View.GONE
                        binding.noInternet.visibility = View.VISIBLE
                        Toast.makeText(requireContext(), "Error...", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    //method do set the movie details to UI components
    private fun setData(movie: MovieDetailsResponse) {
        Glide.with(binding.root).load(Constant.IMAGES_URL + movie.poster_path)
            .placeholder(R.drawable.movie_placholder)
            .into(binding.postrImg)

        binding.movieTitle.text = movie.original_title
        binding.relaseDate.text = movie.release_date
        binding.rate.text = getDecimalRate(movie.vote_average)
        binding.overview.text = movie.overview
    }

  //  method to hide UI components while loading state
    private fun hideComponents() {
        binding.postrImg.visibility = View.GONE
        binding.movieTitle.visibility = View.GONE
        binding.relaseDate.visibility = View.GONE
        binding.rate.visibility = View.GONE
        binding.overview.visibility = View.GONE
        binding.textView4.visibility = View.GONE
        binding.card.visibility = View.GONE
    }

   //method to show UI components when the data arrived
    private fun showComponents() {
        binding.postrImg.visibility = View.VISIBLE
        binding.movieTitle.visibility = View.VISIBLE
        binding.relaseDate.visibility = View.VISIBLE
        binding.rate.visibility = View.VISIBLE
        binding.overview.visibility = View.VISIBLE
        binding.textView4.visibility = View.VISIBLE
        binding.card.visibility = View.VISIBLE
    }

    // Network Observation that observe on statues of internet and handel this state
    private fun checkNetwork() {
        networkObservation = NetworkConnectivityObserver(requireContext())
        lifecycleScope.launch {
            networkObservation.observeOnNetwork().collectLatest {
                when (it.name) {
                    "Available" -> {
                        binding.noInternet.visibility = View.GONE
                        detailsViewModel.getMovieDetails(movieId)
                    }

                    "Lost" -> {
                        Toast.makeText(
                            requireContext(),
                            "You Lost The Network Connection",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    InternetStatus.UnAvailable.name -> {
                        binding.noInternet.visibility = View.VISIBLE
                    }
                }
            }
        }

    }
}