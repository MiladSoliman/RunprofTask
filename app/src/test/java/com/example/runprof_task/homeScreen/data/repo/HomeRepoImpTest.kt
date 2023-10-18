package com.example.runprof_task.homeScreen.data.repo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.runprof_task.homeScreen.data.remote.FakeHomeRemoteDataSource
import com.example.runprof_task.homeScreen.getFakeDataToTest
import com.example.runprof_task.homeScreen.model.Movie
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeRepoImpTest {

    private lateinit var homeRepoImp: HomeRepoImp
    private lateinit var fakeHomeRemoteDataSource: FakeHomeRemoteDataSource
    private lateinit var fakeResponse : List<Movie>


    @Before
    fun setUp(){
        // given -> create objects of repo and remoteDataSource
        fakeHomeRemoteDataSource = FakeHomeRemoteDataSource()
        homeRepoImp = HomeRepoImp(fakeHomeRemoteDataSource)
        fakeResponse = getFakeDataToTest()
    }

    @Test
    fun getFakeDataAndCheckTheResultAsExpectedOrNo() = runBlockingTest {
        //when -> call the method in the repo
       val result = homeRepoImp.getPopularMovies(1)

        assertEquals(result[0].id,fakeResponse[0].id)
    }


    @Test
    fun getSearchedFakeDataAndCheckTheResult() = runBlockingTest {
        //when -> call the method in the useCase
        val result = homeRepoImp.getSearchedMovie("")
        //then -> Check the result as expected or not
        assertEquals(result[0].original_title,fakeResponse[0].title)
    }

}