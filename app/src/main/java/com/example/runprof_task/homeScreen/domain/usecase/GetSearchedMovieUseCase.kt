package com.example.runprof_task.homeScreen.domain.usecase

import com.example.runprof_task.homeScreen.data.remote.RemoteDataSourceImp
import com.example.runprof_task.homeScreen.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetSearchedMovieUseCase @Inject constructor(private val remoteDataSource: RemoteDataSourceImp){

    suspend fun execute(name:String) : List<Movie> {
        return  remoteDataSource.getSearchedMovie(name)
    }
}