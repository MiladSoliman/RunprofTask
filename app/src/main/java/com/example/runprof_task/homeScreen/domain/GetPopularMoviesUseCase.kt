package com.example.runprof_task.homeScreen.domain

import android.util.Log
import com.example.runprof_task.homeScreen.data.RemotDataSource
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor( val remotDataSource : RemotDataSource){
 // val remotDataSource = RemotDataSource()
   suspend fun execute() : List<Movie>{
      Log.i("Mizo","Done")
      return  remotDataSource.getPopularMovies()
    }
}