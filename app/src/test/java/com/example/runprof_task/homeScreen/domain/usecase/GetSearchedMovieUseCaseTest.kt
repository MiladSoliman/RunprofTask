package com.example.runprof_task.homeScreen.domain.usecase

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.runprof_task.homeScreen.domain.FakeHomeRepoImp
import com.example.runprof_task.homeScreen.getFakeDataToTest
import com.example.runprof_task.homeScreen.model.Movie
import junit.framework.TestCase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GetSearchedMovieUseCaseTest{
  private  lateinit var getSearchedMovieUseCase: GetSearchedMovieUseCase
    private  lateinit var fakeHomeRepoImp: FakeHomeRepoImp
    private  lateinit var fakeResult: List<Movie>


    @Before
    fun setUp() {
        // given -> create objects of repo and useCase
        fakeHomeRepoImp = FakeHomeRepoImp()
        getSearchedMovieUseCase = GetSearchedMovieUseCase(fakeHomeRepoImp)
        fakeResult = getFakeDataToTest()
    }


    @Test
    fun getSearchedDataAndCheckTheResult() = runBlockingTest {
        //when -> call the method in the useCase
        val result = getSearchedMovieUseCase.execute("")
        //then -> Check the result as expected or not
        TestCase.assertEquals(result[0].original_title, fakeResult[0].title)
    }
}