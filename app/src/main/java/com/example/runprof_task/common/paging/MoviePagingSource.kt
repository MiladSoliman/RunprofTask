package com.example.runprof_task.common.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.runprof_task.homeScreen.domain.usecase.GetPopularMoviesUseCase
import com.example.runprof_task.homeScreen.model.Movie

/*
*** MoviePagingSource class that provides paging source of data to automatic calling api when 20 items finished
* then call next page
* @param useCase am instance GetPopularMoviesUseCase to call execute method that provides the screen with continuous data
*/
class MoviePagingSource
    (private val useCase: GetPopularMoviesUseCase) :
    PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val response = useCase.execute(currentPage)
            val responseData = mutableListOf<Movie>()
            responseData.addAll(response)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return null
    }
}