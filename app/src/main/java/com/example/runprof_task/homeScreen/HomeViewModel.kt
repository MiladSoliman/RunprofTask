package com.example.runprof_task.homeScreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.runprof_task.common.api.ApiState
import com.example.runprof_task.common.paging.MoviePagingSource
import com.example.runprof_task.homeScreen.domain.GetPopularMoviesUseCase
import com.example.runprof_task.homeScreen.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val  useCase : GetPopularMoviesUseCase ) :ViewModel() {

//    val useCase =  GetPopularMoviesUseCase()

    val isLoading = MutableStateFlow<Boolean>(true)

    private var _popularMovies = MutableStateFlow<ApiState>(ApiState.Loading)
    var  popularMovies : StateFlow<ApiState> = _popularMovies


 val moviesList   =
      Pager(PagingConfig(1)) {
          MoviePagingSource(useCase)
      }.flow.cachedIn(viewModelScope)





    init {
    //   getMovies()
    }

     private fun getMovies() {
   /*     viewModelScope.launch {
         try {
            _popularMovies.value = ApiState.Success (
                Pager(PagingConfig(1)) {
                    MoviePagingSource(useCase)
                }.flow.cachedIn(viewModelScope)
            )
          }catch(e:Exception) {
             _popularMovies.value = ApiState.Failure(e)
          }*/
        //    moviesList = Pager(PagingConfig(1))



        }
    }


