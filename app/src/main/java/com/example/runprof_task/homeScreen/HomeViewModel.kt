package com.example.runprof_task.homeScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.runprof_task.common.paging.MoviePagingSource
import com.example.runprof_task.homeScreen.domain.usecase.GetPopularMoviesUseCase
import com.example.runprof_task.homeScreen.domain.usecase.GetSearchedMovieUseCase
import com.example.runprof_task.homeScreen.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getSearchedMovieUseCase: GetSearchedMovieUseCase
) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }
    var popularMoviesList: kotlinx.coroutines.flow.Flow<PagingData<Movie>> = flowOf()
    var searchedMoviesList: MutableList<Movie> = mutableListOf()

    init {
        getPopularMovie()
    }
    private fun getPopularMovie() {
        viewModelScope.launch(coroutineExceptionHandler) {
            popularMoviesList = Pager(PagingConfig(1)) {
                MoviePagingSource(getPopularMoviesUseCase)
            }.flow
        }
    }
    fun searchForMovie(name: String) {
        viewModelScope.launch(coroutineExceptionHandler) {
            isLoading.value = true
            delay(1000)
            searchedMoviesList = getSearchedMovieUseCase.execute(name).toMutableList()
            isLoading.value = false

        }

    }


}


