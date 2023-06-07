package com.example.book.request

import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object FanqieRequest {
    private val client = OkHttpClient()

    fun request(url: String): String {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""
    }



    fun post(url: String, map: Map<String, String>): String {
        val body = FormBody.Builder().apply {
            map.forEach { (k, v) ->
                add(k, v)
            }
        }.build()
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""
    }

    fun post(url: String, json: String): String {
        val body = RequestBody.create(
            "application/json".toMediaTypeOrNull(), json
        )
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()
        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""
    }

}