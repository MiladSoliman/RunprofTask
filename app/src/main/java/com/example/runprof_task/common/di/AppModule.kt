
package com.example.runprof_task.common.di

import com.example.runprof_task.common.network.MoviesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
   companion object {
       private const val BASE_URL = "https://api.themoviedb.org/3/"

       @Singleton
       @Provides
       fun weatherRetrofitProvider() : MoviesApiService {
           return  Retrofit
               .Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
               .create(MoviesApiService::class.java)
       }
   }
}
