package com.example.runprof_task.homeScreen.domain.usecase

import android.util.Log
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSource
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSourceImp
import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor( val repo : HomeRepo){
 // val remotDataSource = RemotDataSource()
   suspend fun execute(page:Int) : List<Movie>{
      Log.i("Mizo","Done")
      return  repo.getPopularMovies(page)
    }
}