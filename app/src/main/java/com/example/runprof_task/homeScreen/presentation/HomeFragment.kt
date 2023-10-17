package com.example.runprof_task.homeScreen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.runprof_task.R
import com.example.runprof_task.common.api.ApiState
import com.example.runprof_task.databinding.FragmentHomeBinding
import com.example.runprof_task.homeScreen.HomeViewModel
import com.example.runprof_task.homeScreen.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
   val homeViewModel: HomeViewModel by viewModels()
   lateinit var myMovies: List<Movie>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater)
        homeAdapter = HomeAdapter()
       // homeViewModel  HomeViewModel()
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.homeRV.adapter = homeAdapter
        homeBinding.homeRV.layoutManager = GridLayoutManager(requireContext(),2)
          lifecycleScope.launchWhenCreated {
              homeViewModel.moviesList.collect{
                  homeAdapter.submitData(it)
              }
          }
    }


  /*  fun observeOnData(){
        lifecycleScope.launch {
            homeViewModel.popularMovies.collect{
                when(it) {
                    is ApiState.Loading -> {
                        homeBinding.homeProgressBar.visibility = View.VISIBLE
                    }
                    is ApiState.Success<*> -> {
                        homeBinding.homeProgressBar.visibility = View.GONE
                        myMovies = (it.date  as? List<Movie> ) ?: emptyList()
                        homeAdapter.updateFavList(myMovies)
                    }
                    else -> {
                        homeBinding.homeProgressBar.visibility = View.GONE
                        Toast.makeText(requireContext(),"Error",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }*/
}