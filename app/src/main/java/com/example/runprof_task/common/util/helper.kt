package com.example.runprof_task.common.util

import java.math.RoundingMode
import java.text.DecimalFormat

// method to get movie rate at format (#.#), to be appropriate to UI
fun getDecimalRate(rate: Double): String {
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.DOWN
    return df.format(rate)
}