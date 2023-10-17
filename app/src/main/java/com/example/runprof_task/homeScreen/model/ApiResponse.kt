package com.example.runprof_task.homeScreen.model

data class ApiResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)