package com.example.runprof_task.homeScreen.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.runprof_task.common.network.InternetStatus
import com.example.runprof_task.common.network.NetworkConnectivityObserver
import com.example.runprof_task.common.network.NetworkObservation
import com.example.runprof_task.databinding.FragmentHomeBinding
import com.example.runprof_task.homeScreen.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), OnClickToShowDetails {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    val homeViewModel: HomeViewModel by viewModels()
    private lateinit var networkObservation: NetworkObservation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater)
        homeAdapter = HomeAdapter(this)
        // homeViewModel  HomeViewModel()
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.homeRV.adapter = homeAdapter
        homeBinding.homeRV.layoutManager = GridLayoutManager(requireContext(), 2)
        checkNetwork()
        lifecycleScope.launch {
            homeViewModel.isLoading.observe(viewLifecycleOwner) {
                if (it) {
                    homeBinding.homeProgressBar.visibility = View.VISIBLE
                    homeBinding.homeRV.visibility = View.GONE
                } else {
                    homeBinding.homeProgressBar.visibility = View.GONE
                    homeBinding.homeRV.visibility = View.VISIBLE
                }
            }
        }
        observeOnLoading()
        startObservation()
        homeBinding.homeSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (s.toString().isBlank()) {
                    startObservation()
                    homeViewModel.searchedMoviesList.clear()
                } else {
                    searchForMovie(s.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun searchForMovie(s: String) {
        homeViewModel.searchForMovie(s)
        lifecycleScope.launch {
            homeAdapter.submitData(PagingData.from(homeViewModel.searchedMoviesList))
            homeAdapter.notifyDataSetChanged()
        }
    }

    private fun startObservation() {
        lifecycleScope.launch {
            homeAdapter.submitData(PagingData.empty())
            homeAdapter.notifyDataSetChanged()
            homeViewModel.popularMoviesList.collect {
                homeAdapter.submitData(it)
                homeAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun observeOnLoading() {
        lifecycleScope.launch {
            homeAdapter.loadStateFlow.collect {
                val state = it.refresh
                homeBinding.homeProgressBar.isVisible = state is LoadState.Loading
                homeBinding.homeSearch.isVisible = state !is LoadState.Loading
            }

        }
    }

    override fun showDetails(movieId: Int) {
        val action = HomeFragmentDirections.goToDetailsScreen(movieId)
        Navigation.findNavController(requireView()).navigate(action)
    }

    private fun checkNetwork() {
        networkObservation = NetworkConnectivityObserver(requireContext())
        lifecycleScope.launch {
            networkObservation.observeOnNetwork().collectLatest {
                when (it.name) {
                    "Available" -> {
                        homeBinding.noNetworkSplash.visibility = View.GONE
                        startObservation()
                    }

                    "Lost" -> {
                        Toast.makeText(
                            requireContext(),
                            "You Lost The Network Connection",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    InternetStatus.UnAvailable.name -> {
                        homeBinding.homeSearch.visibility = View.GONE
                        homeBinding.noNetworkSplash.visibility = View.VISIBLE

                    }
                }
            }
        }

    }


}