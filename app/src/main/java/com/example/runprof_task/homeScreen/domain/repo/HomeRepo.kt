package com.example.runprof_task.homeScreen.domain.repo

import com.example.runprof_task.homeScreen.model.Movie

interface HomeRepo {
    suspend fun getPopularMovies(page: Int): List<Movie>
    suspend fun getSearchedMovie(name: String): List<Movie>
}