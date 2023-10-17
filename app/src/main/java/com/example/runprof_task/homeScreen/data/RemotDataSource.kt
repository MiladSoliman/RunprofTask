package com.example.runprof_task.homeScreen.data

import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class RemotDataSource @Inject constructor(val service: MoviesApiService) {

    //var service: MoviesApiService = MovieAPi.retrofitService


    suspend fun getPopularMovies() : List<Movie> {
        return service.getWeatherData().results
    }
}