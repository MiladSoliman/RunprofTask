package com.example.runprof_task.detailsScreen

import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse

fun getFakeMovieDetails() : MovieDetailsResponse {
    return MovieDetailsResponse(
        1,"FakeMovieDetails","FakeOverView","","18/10/2023",9.0
    )
}