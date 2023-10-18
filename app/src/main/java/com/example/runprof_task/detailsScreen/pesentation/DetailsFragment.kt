package com.example.runprof_task.detailsScreen.pesentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.runprof_task.R
import com.example.runprof_task.common.api.ApiState
import com.example.runprof_task.databinding.FragmentDetailsBinding
import com.example.runprof_task.databinding.FragmentHomeBinding
import com.example.runprof_task.detailsScreen.DetailsViewModel
import com.example.runprof_task.homeScreen.presentation.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    lateinit var binding : FragmentDetailsBinding
    private val detailsViewModel : DetailsViewModel by viewModels()
     private var movieId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        movieId = requireArguments().getInt("movieId")
        Log.i("idd","" + movieId)
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsViewModel.getMovieDetails(movieId)
        startObservation()
    }




    private fun startObservation(){
        lifecycleScope.launch {
           detailsViewModel.movieDetails.collect{
               when(it) {
                   is ApiState.Loading -> {
                       Toast.makeText(requireContext(),"Loading...",Toast.LENGTH_SHORT).show()
                   }
                   is ApiState.Success<*> -> {
                       Toast.makeText(requireContext(),"Done...",Toast.LENGTH_SHORT).show()
                   }
                   else -> {
                       Toast.makeText(requireContext(),"Error...",Toast.LENGTH_SHORT).show()
                   }
               }
           }
        }
    }

}