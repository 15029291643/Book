package com.example.book.util

import android.util.Log

val TAG = "haojinhui 23-06-07"

fun Any?.loge(s: String = "") = also {
    Log.e(TAG, "log: ${it ?: "null"}: $s")
}

fun String.loge(s: String = "") = also {
    Log.e(TAG, "log: $it: $s")
}