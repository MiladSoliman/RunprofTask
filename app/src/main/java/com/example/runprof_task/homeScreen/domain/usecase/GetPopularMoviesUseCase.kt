package com.example.runprof_task.homeScreen.domain.usecase

import android.util.Log
import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

/*
*** GetPopularMoviesUseCase Class that responsible for get popular movies list when the app starting
* @param repo to provide execute method with tha data
*/
class GetPopularMoviesUseCase @Inject constructor(val repo: HomeRepo) {

    suspend fun execute(page: Int): List<Movie> {
        return repo.getPopularMovies(page)
    }
}