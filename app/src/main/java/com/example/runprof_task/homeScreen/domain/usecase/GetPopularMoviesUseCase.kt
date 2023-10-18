package com.example.runprof_task.homeScreen.domain.usecase

import android.util.Log
import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(val repo: HomeRepo) {

    suspend fun execute(page: Int): List<Movie> {
        Log.i("Mizo", "Done")
        return repo.getPopularMovies(page)
    }
}