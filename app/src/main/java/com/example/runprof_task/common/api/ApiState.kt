package com.example.runprof_task.common.api

/*
** sealed class that responsible for getting api state
*/
sealed class ApiState {
    class Success<T>(val date: T) : ApiState()
    class Failure(val error: Throwable) : ApiState()
    object Loading : ApiState()
}