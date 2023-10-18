package com.example.runprof_task.detailsScreen.model

data class MovieDetailsResponse(
    val id: Int,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
)