package com.example.runprof_task.detailsScreen.domain.repo

import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse

/*
*** MovieDetailsRepo an interface, for passing data between the layers
*/
interface MovieDetailsRepo {
    suspend fun getMovieDetails(id: Int): MovieDetailsResponse
}