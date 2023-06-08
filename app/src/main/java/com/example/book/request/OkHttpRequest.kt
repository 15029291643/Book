package com.example.book.request

import com.example.book.model.chapter.List1
import com.example.book.util.logeOrPrintln
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
    ): List<List1> {
        val url = "https://search.zongheng.com/search/book?" +
                "keyword=$keyword" +
                "&sort=$sort" +
                "&pageNo=$pageNo" +
                "&pageNum=$pageNum"
        "链接: $url".logeOrPrintln()
        return ZhonghengParse.search(get(url).also {
            "json返回: $it".logeOrPrintln()
        })
    }

    // https://book.zongheng.com/chapter/1245784/70122630.html
    fun chapter(url: String) = ZhonghengParse.chapter(get(url))

    /*
    // 章节名
    https://naodongapi.zongheng.com/planet/book/catalogs
    // 请求体
    {"bookId":1245784}

    * */
    // 通过书的id获取整个目录
    fun catalogs(bookId: String) = ZhonghengParse.catalogs(
        post(
            "https://naodongapi.zongheng.com/planet/book/catalogs",
            "{\"bookId\":$bookId}"
        ).also {
            "目录请求: $it".logeOrPrintln()
        }.also {
            "目录返回：$it".logeOrPrintln()
        }
    )

    // 第一章链接
    fun read(tomeId: String) = "http://book.zongheng.com/book/$tomeId".let {
        ZhonghengParse.read(get(it))
    }
}

fun main() {
    println(OkHttpRequest.catalogs("1245784"))
}
