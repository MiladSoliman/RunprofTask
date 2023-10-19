package com.example.runprof_task.homeScreen.domain.usecase

import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import com.example.runprof_task.homeScreen.model.Movie
import javax.inject.Inject
/*
*** GetSearchedMovieUseCase Class that responsible for get searched movies list, has execute method that takes
* movie name as parameter
*
** @param repo to provide execute method with tha data
*/
class GetSearchedMovieUseCase @Inject constructor(private val repo: HomeRepo) {

    suspend fun execute(name: String): List<Movie> {
        return repo.getSearchedMovie(name)
    }
}