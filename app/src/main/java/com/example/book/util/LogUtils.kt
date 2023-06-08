package com.example.book.util

import android.util.Log

val TAG = "haojinhui 23-06-07"

// fun String.loge(s: String = "") = Log.e(TAG, "log: $this: $s")
fun String.loge(s: String = "") = Log.e(TAG, "log: $this: $s")

fun String.show(s: String = "") {
    try {
        Log.e(TAG, "$this: s")
    } catch (_: Exception) {
        println("$this: $s")
    }
}
fun String.logeOrPrintln() {
    try {
        Log.e(TAG, this)
    } catch (_: Exception) {
        println(this)
    }
}

fun loge(s: String = "") = Log.e(TAG, "log: $s")