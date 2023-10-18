package com.example.runprof_task.homeScreen.domain.usecase

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.runprof_task.homeScreen.domain.FakeHomeRepoImp
import com.example.runprof_task.homeScreen.getFakeDataToTest
import com.example.runprof_task.homeScreen.model.Movie
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GetPopularMoviesUseCaseTest {
    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase
    lateinit var fakeHomeRepoImp: FakeHomeRepoImp
    lateinit var fakeResponse : List<Movie>

    @Before
    fun setUp(){
        // given -> create objects of repo and useCase
        fakeHomeRepoImp = FakeHomeRepoImp()
        getPopularMoviesUseCase = GetPopularMoviesUseCase(fakeHomeRepoImp)
        fakeResponse = getFakeDataToTest()
    }


    @Test
    fun getFakeDataAndTestTheResult() = runBlockingTest {
        //when -> call the method in the useCase
        val result = getPopularMoviesUseCase.execute(1)
        //then -> Check the result as expected or not
        assertThat(result, CoreMatchers.not(CoreMatchers.nullValue()))
    }
}