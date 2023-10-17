package com.example.runprof_task.homeScreen.domain.repo

import com.example.runprof_task.homeScreen.model.Movie

interface HomeRepo {
    suspend fun getPopularMovies():List<Movie>
}