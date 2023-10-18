package com.example.runprof_task.detailsScreen.data.repo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.runprof_task.detailsScreen.data.remot.FakeMovieDetailsRemoteSource
import com.example.runprof_task.detailsScreen.getFakeMovieDetails
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDetailsRepoImpTest {
    private lateinit var movieDetailsRepoImp: MovieDetailsRepoImp
    private lateinit var fakeMovieDetailsRepoImp: FakeMovieDetailsRemoteSource
   private lateinit var fakeResponse : MovieDetailsResponse


    @Before
    fun setUp(){
        // given -> create objects of repo and remoteDataSource
        fakeMovieDetailsRepoImp = FakeMovieDetailsRemoteSource()
        movieDetailsRepoImp = MovieDetailsRepoImp(fakeMovieDetailsRepoImp)
        fakeResponse = getFakeMovieDetails()
    }


    @Test
    fun getMovieDetailsAndCheckTheResult() = runBlockingTest {
        //when -> call the method in the repo
        val result = movieDetailsRepoImp.getMovieDetails(1)
        //then -> Check the result as expected or not
        assertEquals(result.overview,fakeResponse.overview)
    }

}