package com.example.runprof_task.detailsScreen.domain.usecase

import com.example.runprof_task.detailsScreen.domain.repo.MovieDetailsRepo
import com.example.runprof_task.detailsScreen.getFakeMovieDetails
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse

class FakeMovieDetailsRepoImp : MovieDetailsRepo {
    override suspend fun getMovieDetails(id: Int): MovieDetailsResponse {
        return getFakeMovieDetails()
    }
}