package com.example.runprof_task.homeScreen.data

import com.example.runprof_task.homeScreen.model.ApiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

/*
object RetrofitHelper {

    const val BASE_URL = "https://api.themoviedb.org/3/movie/"


    val retrofitInstance = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}

object MovieAPi {
    val retrofitService: MoviesApiService by lazy {
        RetrofitHelper.retrofitInstance.create(MoviesApiService::class.java)
    }
}

*/




interface MoviesApiService {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxOTVhZjViMjYxODI0YzcxZmFkMDY3NDI1YTI4OTAxMyIsInN1YiI6IjY1MmQ5MzViNjYxMWI0MDEzOWI0Y2UxOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8R6whmC0RKvTFDVhm2bimKvygzShD_ekXTsSIEfnLkI")
    @GET("popular")
    suspend fun getWeatherData(
    ) : ApiResponse
}