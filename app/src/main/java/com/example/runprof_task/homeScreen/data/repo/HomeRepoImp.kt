package com.example.runprof_task.homeScreen.data.repo

import com.example.runprof_task.homeScreen.data.remote.RemoteDataSource
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSourceImp
import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject

class HomeRepoImp @Inject constructor(val remote:RemoteDataSourceImp) : HomeRepo {
    override suspend fun getPopularMovies(page:Int): List<Movie> {
        return remote.getPopularMovies(page)
    }
}