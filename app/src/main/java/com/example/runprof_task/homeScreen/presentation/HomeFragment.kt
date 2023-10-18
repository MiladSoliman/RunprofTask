package com.example.runprof_task.homeScreen.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
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
         /* lifecycleScope.launchWhenCreated {
              homeViewModel.moviesList.collect{
                  homeAdapter.submitData(it)
              }
          }*/
        lifecycleScope.launch {
            homeViewModel.isLoading.observe(viewLifecycleOwner){
                if (it){
                    homeBinding.homeProgressBar.visibility = View.VISIBLE
                    homeBinding.homeRV.visibility = View.GONE
                }else{
                    homeBinding.homeProgressBar.visibility = View.GONE
                    homeBinding.homeRV.visibility = View.VISIBLE
                }
            }
        }
        observeOnLoading()
        startObservation()


        homeBinding.homeSearch.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (s.toString().isBlank()) {
                    startObservation()
                    homeViewModel.myList.clear()
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
            homeAdapter.submitData(PagingData.from(homeViewModel.myList))
            homeAdapter.notifyDataSetChanged()
        }
    }


   /*   fun observeOnData(){
          lifecycleScope.launch {
              homeViewModel.popularMovies.collect{
                  when(it) {
                      is ApiState.Loading -> {
                          homeBinding.homeProgressBar.visibility = View.VISIBLE
                      }
                      is ApiState.Success-> {
                          homeBinding.homeProgressBar.visibility = View.GONE
                            startObservation()
                      }
                      else -> {
                          homeBinding.homeProgressBar.visibility = View.GONE
                          Toast.makeText(requireContext(),"Error",Toast.LENGTH_SHORT).show()
                      }
                  }
              }
          }
      }*/


  private fun startObservation(){
        lifecycleScope.launch {
            homeAdapter.submitData(PagingData.empty())
            homeAdapter.notifyDataSetChanged()
            homeViewModel.moviesList.collect{
                homeAdapter.submitData(it)
                homeAdapter.notifyDataSetChanged()
            }
        }
  }

  private fun observeOnLoading(){
      lifecycleScope.launch {
          homeAdapter.loadStateFlow.collect{
              val state = it.refresh
              homeBinding.homeProgressBar.isVisible = state is LoadState.Loading
          }

      }
  }






}