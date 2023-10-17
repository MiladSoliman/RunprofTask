package com.example.runprof_task.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runprof_task.homeScreen.domain.GetPopularMoviesUseCase

import kotlinx.coroutines.launch

class HomeViewModel :ViewModel() {

    val useCase =  GetPopularMoviesUseCase()


    init {
        printLogs()
        getMovies()
        Log.i("Mizooo","Printt")
    }

     fun getMovies() {
        viewModelScope.launch {
         val list  = useCase.execute()

           Log.i("Mizooo","DAta" + list.size)
        }
    }

     fun printLogs(){
        Log.i("Mizooo","Printt")
    }
}