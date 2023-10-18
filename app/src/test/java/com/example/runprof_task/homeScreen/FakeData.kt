package com.example.runprof_task.homeScreen

import com.example.runprof_task.homeScreen.model.Movie

fun getFakeDataToTest() : List<Movie> {
    return listOf(
        Movie(
            1,"FakeMovie1","FakeOverView1","","18/10/2023","FakeMovie1",9.8
        ),
        Movie(
            2,"FakeMovie2","FakeOverView2","","18/10/2023","FakeMovie2",9.0
        )
    )
}