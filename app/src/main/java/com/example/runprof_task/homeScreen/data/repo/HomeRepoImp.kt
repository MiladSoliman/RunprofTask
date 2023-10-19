package com.example.runprof_task.homeScreen.data.repo

import com.example.runprof_task.homeScreen.data.remote.RemoteDataSource
import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject
/*
** HomeRepoImp implement HomeRepo interface, provide implementation for methods to pass return data to use case classes
*
**@param remote instance of RemoteDataSource interface that responsible for getting data from remote data source
*/
class HomeRepoImp @Inject constructor(val remote: RemoteDataSource) : HomeRepo {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return remote.getPopularMovies(page)
    }

    override suspend fun getSearchedMovie(name: String): List<Movie> {
        return remote.getSearchedMovie(name)
    }
}