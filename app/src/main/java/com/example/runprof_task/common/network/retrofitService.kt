package com.example.runprof_task.common.network

import com.example.runprof_task.common.util.Constant
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import com.example.runprof_task.homeScreen.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
/*
** MoviesApiService with Get method to get the data from api
*/
interface MoviesApiService {
    @Headers(Constant.AUTH)
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int = 1): ApiResponse


    @Headers(Constant.AUTH)
    @GET("search/movie")
    suspend fun getSearchedMovies(@Query("query") name: String): ApiResponse


    @Headers(Constant.AUTH)
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") id: Int): MovieDetailsResponse
}