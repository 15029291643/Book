package com.example.book.thread

import java.util.concurrent.Executors

object ThreadPool {
    private val service = Executors.newCachedThreadPool()
    fun submit(runnable: Runnable) = service.submit(runnable)
}
