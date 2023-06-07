package com.example.book.request

import com.example.book.model.chapter.ChapterResponse
import com.google.gson.Gson
import org.jsoup.Jsoup

object ZhonghengParse {
    private val gson = Gson()
    fun search(json: String) =
        gson.fromJson(json.also {
                                println("返回json：$json")
        }, ChapterResponse::class.java).also {
            println("解析陈工: $it")
        }.data?.recDataList ?: emptyList()

    fun chapter(html: String) = mutableListOf<String>().apply {
        Jsoup.parse(html).select("#readerFt > div > div.reader_box > div.content > p").forEach {
            this += it.text().trim()
        }
    }
}
