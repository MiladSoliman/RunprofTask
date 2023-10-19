package com.example.runprof_task.detailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runprof_task.common.api.ApiState
import com.example.runprof_task.detailsScreen.domain.usecase.GetMoveDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
 ** HomeViewModel class for the Popular Movies List and Searched Movies List
 ** @param getMovieDetailsUseCase The use case that responsible for providing selected movies details
*/
@HiltViewModel
class DetailsViewModel @Inject constructor(private val getMovieDetailsUseCase: GetMoveDetailsUseCase) :
    ViewModel() {

    private val _movieDetails: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Loading)
    val movieDetails = _movieDetails

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    fun getMovieDetails(id: Int) {
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                val movie = getMovieDetailsUseCase.execute(id)
                _movieDetails.value = ApiState.Success(movie)
            } catch (e: Exception) {
                _movieDetails.value = ApiState.Failure(e)
            }

        }
    }
}