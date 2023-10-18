package com.example.runprof_task.detailsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runprof_task.common.api.ApiState
import com.example.runprof_task.detailsScreen.domain.usecase.GetMoveDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DetailsViewModel @Inject constructor(private val useCase: GetMoveDetailsUseCase) :ViewModel() {

    private val _movieDetails : MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
    val movieDetails = _movieDetails

    fun getMovieDetails(id:Int) {
        viewModelScope.launch {
          try {
              val movie = useCase.execute(id)
              _movieDetails.value = ApiState.Success(movie)
          }catch (e:Exception){
              _movieDetails.value = ApiState.Failure(e)
          }

        }
    }
}