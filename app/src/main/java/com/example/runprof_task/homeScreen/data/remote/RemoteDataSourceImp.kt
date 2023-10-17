package com.example.runprof_task.homeScreen.data.remote

import com.example.runprof_task.homeScreen.data.service.MoviesApiService
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(val service: MoviesApiService) {

    //var service: MoviesApiService = MovieAPi.retrofitService


    suspend fun getPopularMovies() : List<Movie> {
        return service.getWeatherData().results
    }
}