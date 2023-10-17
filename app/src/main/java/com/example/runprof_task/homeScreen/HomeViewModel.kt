package com.example.runprof_task.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runprof_task.homeScreen.domain.GetPopularMoviesUseCase
import com.example.runprof_task.homeScreen.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

class HomeViewModel :ViewModel() {

    val useCase =  GetPopularMoviesUseCase()

    private var _popularMovies = MutableStateFlow<List<Movie>>(emptyList())
    var  popularMovies : StateFlow<List<Movie>> = _popularMovies

    init {
        printLogs()
        getMovies()
        Log.i("Mizooo","Printt")
    }

     fun getMovies() {
        viewModelScope.launch {
         val list  = useCase.execute()
          _popularMovies.value = list
           Log.i("Mizooo","DAta" + list.size)
        }
    }

     fun printLogs(){
        Log.i("Mizooo","Printt")
    }
}