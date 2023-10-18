package com.example.runprof_task.homeScreen.data.remote

import com.example.runprof_task.common.network.MoviesApiService
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(val service: MoviesApiService) : RemoteDataSource {

    //var service: MoviesApiService = MovieAPi.retrofitService


 override suspend fun getPopularMovies(page:Int) : List<Movie> {
        return service.getPopularMovies(page).results
    }

    override suspend fun getSearchedMovie(name: String): List<Movie> {
        return service.getSearchedMovies(name).results
    }
}