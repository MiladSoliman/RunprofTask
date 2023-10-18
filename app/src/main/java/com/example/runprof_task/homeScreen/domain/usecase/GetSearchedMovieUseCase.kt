package com.example.runprof_task.homeScreen.domain.usecase

import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class GetSearchedMovieUseCase @Inject constructor(private val repo: HomeRepo) {

    suspend fun execute(name: String): List<Movie> {
        return repo.getSearchedMovie(name)
    }
}