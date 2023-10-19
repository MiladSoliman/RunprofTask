package com.example.runprof_task.common.di

import com.example.runprof_task.common.network.MoviesApiService
import com.example.runprof_task.common.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*
*** AppModule a module that provides singleton instance of MoviesApiService interface along the application
*/
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun weatherRetrofitProvider(): MoviesApiService {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MoviesApiService::class.java)
    }

}
