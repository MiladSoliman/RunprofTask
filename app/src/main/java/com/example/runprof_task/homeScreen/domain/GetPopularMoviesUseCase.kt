package com.example.runprof_task.homeScreen.domain

import android.util.Log
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSourceImp
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor( val remotDataSource : RemoteDataSourceImp){
 // val remotDataSource = RemotDataSource()
   suspend fun execute(page:Int) : List<Movie>{
      Log.i("Mizo","Done")
      return  remotDataSource.getPopularMovies(page)
    }
}