package com.example.runprof_task.common.api

sealed class ApiState {
    class Success() : ApiState()
    class Failure(val error: Throwable) : ApiState()
    object Loading : ApiState()
}