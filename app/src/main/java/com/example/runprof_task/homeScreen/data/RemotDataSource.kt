package com.example.runprof_task.homeScreen.data

import com.example.runprof_task.homeScreen.model.Movie

class RemotDataSource  {

    var service: MoviesApiService = MovieAPi.retrofitService


    suspend fun getPopularMovies() : List<Movie> {
        return service.getWeatherData().results
    }
}