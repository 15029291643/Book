package com.example.book.request

import com.example.book.model.chapter.RecDataList
import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object OkHttpRequest {
    private val client = OkHttpClient()

    private fun post(url: String, map: Map<String, String>): String {
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

    private fun get(url: String): String {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        return response.body?.string() ?: ""
    }

    private fun post(url: String, json: String): String {
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

    /*
    https://search.zongheng.com/search/book?
    keyword=斗罗大陆
    &sort=null
    &pageNo=1
    &pageNum=20
    &isFromHuayu=0
    * */
    fun search(
        keyword: String,
        sort: String = "null",
        pageNo: Int = 1,
        pageNum: Int = 20
    ): List<RecDataList> {
        val url = "https://search.zongheng.com/search/book?" +
                "keyword=$keyword" +
                "&sort=$sort" +
                "&pageNo=$pageNo" +
                "&pageNum=$pageNum"
        return ZhonghengParse.search(get(url))
    }

    // https://book.zongheng.com/chapter/1245784/70122630.html
    fun chapter(url: String) = ZhonghengParse.chapter(get(url))

    /*
    // 章节名
    https://naodongapi.zongheng.com/planet/book/catalogs
    // 请求体
    {"bookId":1245784}

    * */
    fun catalogs(url: String, json: String) = post(url, json)
}

fun main() {
    println(OkHttpRequest.search("斗罗"))
}
