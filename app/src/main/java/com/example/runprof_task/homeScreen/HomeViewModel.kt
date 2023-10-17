package com.example.runprof_task.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runprof_task.homeScreen.domain.GetPopularMoviesUseCase
import com.example.runprof_task.homeScreen.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val  useCase : GetPopularMoviesUseCase ) :ViewModel() {

//    val useCase =  GetPopularMoviesUseCase()

    private var _popularMovies = MutableStateFlow<List<Movie>>(emptyList())
    var  popularMovies : StateFlow<List<Movie>> = _popularMovies

    init {
        getMovies()

    }

     private fun getMovies() {
        viewModelScope.launch {
         val list  = useCase.execute(5)
          _popularMovies.value = list
           Log.i("Mizooo","DAta" + list.size)
        }
    }


}