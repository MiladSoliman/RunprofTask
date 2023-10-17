package com.example.runprof_task.homeScreen.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.runprof_task.R
import com.example.runprof_task.databinding.FragmentHomeBinding
import com.example.runprof_task.homeScreen.HomeViewModel
import com.example.runprof_task.homeScreen.model.Movie
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel
  //  lateinit var myMovies: List<Movie>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater)
        homeAdapter = HomeAdapter(listOf())
        homeViewModel = HomeViewModel()
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.homeRV.adapter = homeAdapter
        homeBinding.homeRV.layoutManager = GridLayoutManager(requireContext(),2)
        lifecycleScope.launch {
            homeViewModel.popularMovies.collect{
               homeAdapter.updateFavList(it)
            }
        }
    }

}