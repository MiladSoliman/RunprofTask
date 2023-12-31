package com.example.runprof_task.homeScreen.data.remote

import com.example.runprof_task.common.network.MoviesApiService
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

/*
** RemoteDataSourceImp class implement RemoteDataSource interface and provides implementation to this method
*
* @param service an instance of MoviesApiService that responsible to get data from api with Get method
*/
class RemoteDataSourceImp @Inject constructor(private val service: MoviesApiService) :
    RemoteDataSource {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return service.getPopularMovies(page).results
    }

    override suspend fun getSearchedMovie(name: String): List<Movie> {
        return service.getSearchedMovies(name).results
    }
}