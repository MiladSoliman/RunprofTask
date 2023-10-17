/*
package com.example.runprof_task.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.runprof_task.homeScreen.domain.GetPopularMoviesUseCase
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val useCase: GetPopularMoviesUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {

            HomeViewModel(useCase) as T

        } else {

            throw IllegalArgumentException("ViewModel Class not found")

        }
    }
}*/
