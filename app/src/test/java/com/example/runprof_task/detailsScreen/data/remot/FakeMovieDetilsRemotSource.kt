package com.example.runprof_task.detailsScreen.data.remot

import com.example.runprof_task.detailsScreen.data.remoteSource.MovieDetailsRemoteDataSource
import com.example.runprof_task.detailsScreen.getFakeMovieDetails
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse

class FakeMovieDetailsRemoteSource : MovieDetailsRemoteDataSource {
    override suspend fun getMovieDetails(id: Int): MovieDetailsResponse {
        return getFakeMovieDetails()
    }
}



