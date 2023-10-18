package com.example.runprof_task.common.util

import java.math.RoundingMode
import java.text.DecimalFormat

fun getDecimalRate(rate:Double) : String {
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.DOWN
    val roundoff = df.format(rate)
    return roundoff
}