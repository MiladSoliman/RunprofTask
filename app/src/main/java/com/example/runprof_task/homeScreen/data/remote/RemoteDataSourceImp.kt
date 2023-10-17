package com.example.runprof_task.homeScreen.data.remote

import com.example.runprof_task.homeScreen.data.service.MoviesApiService
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(val service: MoviesApiService) : RemoteDataSource {

    //var service: MoviesApiService = MovieAPi.retrofitService


 override suspend fun getPopularMovies(page:Int) : List<Movie> {
        return service.getWeatherData(page).results
    }
}