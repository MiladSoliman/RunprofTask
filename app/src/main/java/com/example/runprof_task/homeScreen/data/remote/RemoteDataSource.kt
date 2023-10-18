package com.example.runprof_task.homeScreen.data.remote

import com.example.runprof_task.homeScreen.model.Movie

interface RemoteDataSource {
    suspend fun getPopularMovies(page: Int): List<Movie>

    suspend fun getSearchedMovie(name: String): List<Movie>
}