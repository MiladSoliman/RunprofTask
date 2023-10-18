package com.example.runprof_task.homeScreen.domain

import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.getFakeDataToTest
import com.example.runprof_task.homeScreen.model.Movie

class FakeHomeRepoImp : HomeRepo {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return getFakeDataToTest()
    }

    override suspend fun getSearchedMovie(name: String): List<Movie> {
        return getFakeDataToTest()
    }
}