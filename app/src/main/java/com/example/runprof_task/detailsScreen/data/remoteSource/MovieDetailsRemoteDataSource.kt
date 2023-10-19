package com.example.runprof_task.detailsScreen.data.remoteSource

import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
/*
*** MovieDetailsRemoteDataSource an interface, for passing data between the layers
*/
interface MovieDetailsRemoteDataSource {
    suspend fun getMovieDetails(id: Int): MovieDetailsResponse
}