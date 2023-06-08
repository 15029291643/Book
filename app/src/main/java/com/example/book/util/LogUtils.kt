package com.example.book.util

import android.util.Log

val TAG = "haojinhui 23-06-07"


fun String.logeOrPrintln() {
    try {
        Log.e(TAG, this)
    } catch (_: Exception) {
        println(this)
    }
}

