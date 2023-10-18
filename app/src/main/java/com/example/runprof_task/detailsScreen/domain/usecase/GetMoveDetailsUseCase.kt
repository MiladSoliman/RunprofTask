package com.example.runprof_task.detailsScreen.domain.usecase

import com.example.runprof_task.detailsScreen.data.repo.MovieDetailsRepoImp
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import javax.inject.Inject

class GetMoveDetailsUseCase @Inject constructor(private val repo : MovieDetailsRepoImp){

    suspend fun execute (id:Int) : MovieDetailsResponse {
        return repo.getMovieDetails(id)
    }
}