package com.example.runprof_task.detailsScreen.domain.usecase

import com.example.runprof_task.detailsScreen.domain.repo.MovieDetailsRepo
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import javax.inject.Inject

/*
*** GetMoveDetailsUseCase Class that responsible for getting selected movie details
* @param repo an instance of MovieDetailsRepo interface to provide execute method with tha data
*/
class GetMoveDetailsUseCase @Inject constructor(private val repo: MovieDetailsRepo) {

    suspend fun execute(id: Int): MovieDetailsResponse {
        return repo.getMovieDetails(id)
    }
}