package com.example.runprof_task.detailsScreen.di

import com.example.runprof_task.detailsScreen.data.remoteSource.MovieDetailsRemoteDataSource
import com.example.runprof_task.detailsScreen.data.remoteSource.MovieDetailsRemoteDataSourceImp
import com.example.runprof_task.detailsScreen.data.repo.MovieDetailsRepoImp
import com.example.runprof_task.detailsScreen.domain.repo.MovieDetailsRepo
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSource
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSourceImp
import com.example.runprof_task.homeScreen.data.repo.HomeRepoImp
import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped




@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieDetailsModule {
    @ViewModelScoped
    @Binds
    abstract fun bindMovieDetailsRemoteDataSource(movieDetailsRemoteDataSourceImp: MovieDetailsRemoteDataSourceImp) : MovieDetailsRemoteDataSource

    @ViewModelScoped
    @Binds
    abstract fun bindMovieDetailsRepo(movieDetailsRepoImp: MovieDetailsRepoImp) : MovieDetailsRepo
}