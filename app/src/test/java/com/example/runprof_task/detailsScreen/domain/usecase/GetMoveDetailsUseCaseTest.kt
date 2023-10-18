package com.example.runprof_task.detailsScreen.domain.usecase

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.runprof_task.detailsScreen.getFakeMovieDetails
import com.example.runprof_task.detailsScreen.model.MovieDetailsResponse
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GetMoveDetailsUseCaseTest {
  private lateinit var getMoveDetailsUseCase: GetMoveDetailsUseCase
  private lateinit var fakeMovieRepoImp : FakeMovieDetailsRepoImp
  private lateinit var fakeResult: MovieDetailsResponse

  @Before
  fun setUp(){
      // given -> create objects of repo and useCase
      fakeMovieRepoImp = FakeMovieDetailsRepoImp()
      getMoveDetailsUseCase = GetMoveDetailsUseCase(fakeMovieRepoImp)
      fakeResult = getFakeMovieDetails()
  }


  @Test
  fun getMovieDetailsAndCheckTheResult() = runBlockingTest {
      //when -> call the method in the useCase
      val result = getMoveDetailsUseCase.execute(1)
      //then -> Check the result as expected or not
      assertEquals(result.poster_path,"")
  }



}