package com.example.book.request

import com.example.book.model.chapter.SearchResponse
import com.google.gson.Gson
import org.jsoup.Jsoup

object ZhonghengParse {
    private val gson = Gson()
    fun search(json: String) =
        gson.fromJson(json, SearchResponse::class.java).data?.recDataList ?: emptyList()

    fun chapter(html: String) = mutableListOf<String>().apply {
        Jsoup.parse(html).select("#readerFt > div > div.reader_box > div.content > p").forEach {
            this += it.text().trim()
        }
    }
}
