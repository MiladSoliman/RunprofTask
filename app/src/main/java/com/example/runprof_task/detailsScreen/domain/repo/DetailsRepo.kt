package com.example.runprof_task.detailsScreen.domain.repo

import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse

interface MovieDetailsRepo {
  suspend fun getMovieDetails(id:Int) : MovieDetailsResponse
}