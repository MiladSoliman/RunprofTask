package com.example.runprof_task.homeScreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.runprof_task.common.api.ApiState
import com.example.runprof_task.common.paging.MoviePagingSource
import com.example.runprof_task.homeScreen.domain.usecase.GetPopularMoviesUseCase
import com.example.runprof_task.homeScreen.domain.usecase.GetSearchedMovieUseCase
import com.example.runprof_task.homeScreen.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val  getPopularMoviesUseCase : GetPopularMoviesUseCase,
    private val getSearchedMovieUseCase: GetSearchedMovieUseCase
) :ViewModel() {

//    val useCase =  GetPopularMoviesUseCase()

    val isLoading = MutableLiveData<Boolean>()

    private var _popularMovies = MutableStateFlow<ApiState>(ApiState.Loading)
    var  popularMovies : StateFlow<ApiState> = _popularMovies


 val moviesList   =
      Pager(PagingConfig(1)) {
          MoviePagingSource(getPopularMoviesUseCase)
      }.flow.cachedIn(viewModelScope)

    var mm : kotlinx.coroutines.flow.Flow <PagingData<Movie>> = flowOf()


   var myList : List<Movie> = emptyList()
    init {
    //   getMovies()
    }

   /*  private fun getMovies() {
   *//*     viewModelScope.launch {
         try {
            _popularMovies.value = ApiState.Success (
                Pager(PagingConfig(1)) {
                    MoviePagingSource(useCase)
                }.flow.cachedIn(viewModelScope)
            )
          }catch(e:Exception) {
             _popularMovies.value = ApiState.Failure(e)
          }*//*
        //    moviesList = Pager(PagingConfig(1))

        }*/

    fun searchForMovie(name:String) {
        viewModelScope.launch {
           try {
               isLoading.value = true
               delay(1000)
               myList =  getSearchedMovieUseCase.execute(name)
               isLoading.value = false
           }catch (e:Exception){
               ApiState.Failure(e)
           }

           Log.i("Dodo","" + myList.size)
        }

    }


}


