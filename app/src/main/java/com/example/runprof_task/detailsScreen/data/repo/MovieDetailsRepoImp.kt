package com.example.runprof_task.detailsScreen.data.repo

import com.example.runprof_task.detailsScreen.data.remoteSource.MovieDetailsRemoteDataSource
import com.example.runprof_task.detailsScreen.domain.repo.MovieDetailsRepo
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import javax.inject.Inject

class MovieDetailsRepoImp @Inject constructor(private val remote: MovieDetailsRemoteDataSource) :
    MovieDetailsRepo {
    override suspend fun getMovieDetails(id: Int): MovieDetailsResponse {
        return remote.getMovieDetails(id)
    }
}