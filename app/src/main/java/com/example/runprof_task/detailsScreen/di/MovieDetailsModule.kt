package com.example.runprof_task.detailsScreen.di

import com.example.runprof_task.detailsScreen.data.remoteSource.MovieDetailsRemoteDataSource
import com.example.runprof_task.detailsScreen.data.remoteSource.MovieDetailsRemoteDataSourceImp
import com.example.runprof_task.detailsScreen.data.repo.MovieDetailsRepoImp
import com.example.runprof_task.detailsScreen.domain.repo.MovieDetailsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
/*
** MovieDetailsModule to provides instance of interfaces
*/

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieDetailsModule {
    @ViewModelScoped
    @Binds
    abstract fun bindMovieDetailsRemoteDataSource(movieDetailsRemoteDataSourceImp: MovieDetailsRemoteDataSourceImp): MovieDetailsRemoteDataSource

    @ViewModelScoped
    @Binds
    abstract fun bindMovieDetailsRepo(movieDetailsRepoImp: MovieDetailsRepoImp): MovieDetailsRepo
}