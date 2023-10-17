package com.example.runprof_task.homeScreen.data.service

import com.example.runprof_task.homeScreen.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApiService {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxOTVhZjViMjYxODI0YzcxZmFkMDY3NDI1YTI4OTAxMyIsInN1YiI6IjY1MmQ5MzViNjYxMWI0MDEzOWI0Y2UxOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8R6whmC0RKvTFDVhm2bimKvygzShD_ekXTsSIEfnLkI")
    @GET("popular")
    suspend fun getWeatherData(@Query ("page") page :Int =1) : ApiResponse
}