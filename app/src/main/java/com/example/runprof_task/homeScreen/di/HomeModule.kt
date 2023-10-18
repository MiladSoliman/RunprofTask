package com.example.runprof_task.homeScreen.di
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSource
import com.example.runprof_task.homeScreen.data.remote.RemoteDataSourceImp
import com.example.runprof_task.homeScreen.data.repo.HomeRepoImp
import com.example.runprof_task.homeScreen.domain.repo.HomeRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeMoviesModule {
    @ViewModelScoped
    @Binds
    abstract fun bindHomeRemoteDataSource(remoteDataSourceImp: RemoteDataSourceImp) : RemoteDataSource

    @ViewModelScoped
    @Binds
    abstract fun bindHomeRepo(homeRepoImp: HomeRepoImp) : HomeRepo
}


