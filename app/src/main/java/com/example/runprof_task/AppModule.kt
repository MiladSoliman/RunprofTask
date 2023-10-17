/*
package com.example.runprof_task

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
       private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

       @Singleton
       @Provides
       fun weatherRetrofitProvider() : Retrofit{
           return  Retrofit
               .Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
       }
   }
}*/
