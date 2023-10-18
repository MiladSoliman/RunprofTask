package com.example.runprof_task.detailsScreen.data.remoteSource

import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse

interface MovieDetailsRemoteDataSource {
  suspend  fun getMovieDetails(id:Int) : MovieDetailsResponse
}