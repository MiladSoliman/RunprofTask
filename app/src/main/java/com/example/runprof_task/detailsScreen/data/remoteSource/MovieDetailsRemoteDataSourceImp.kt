package com.example.runprof_task.detailsScreen.data.remoteSource

import com.example.runprof_task.common.network.MoviesApiService
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import javax.inject.Inject

class MovieDetailsRemoteDataSourceImp @Inject constructor(private val service: MoviesApiService) :
    MovieDetailsRemoteDataSource {
    override suspend fun getMovieDetails(id: Int): MovieDetailsResponse {
        return service.getMovieDetails(id)
    }
}