package com.example.book.util

import android.util.Log

val TAG = "haojinhui 23-06-07"
// fun String.loge(s: String = "") = Log.e(TAG, "log: $this: $s")
fun String.loge(s: String = "") = println("$this: $s")

fun loge(s: String = "")  = Log.e(TAG, "log: $s")