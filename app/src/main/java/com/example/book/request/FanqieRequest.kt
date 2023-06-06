package com.example.book.request

import okhttp3.OkHttpClient
import okhttp3.Request

object FanqieRequest {
    private val client = OkHttpClient()

    fun request(url: String): String {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""
    }

    fun search(name: String): List<Book> {
        val url = "https://fanqienovel.com/search/$name"
        println(url)
        return FanqieFormat.search(request(url))
    }
}

fun main() {
    FanqieRequest.search("斗罗大陆")
}