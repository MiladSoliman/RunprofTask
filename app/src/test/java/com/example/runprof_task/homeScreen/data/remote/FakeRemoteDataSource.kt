package com.example.runprof_task.homeScreen.data.remote

import com.example.runprof_task.homeScreen.getFakeDataToTest
import com.example.runprof_task.homeScreen.model.Movie

class FakeHomeRemoteDataSource : RemoteDataSource {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return getFakeDataToTest()
    }

    override suspend fun getSearchedMovie(name: String): List<Movie> {
        return getFakeDataToTest()
    }
}