package com.example.book.request

import com.example.book.model.catalog.CatalogResponse
import com.example.book.model.chapter.ChapterResponse
import com.google.gson.Gson
import org.jsoup.Jsoup

object ZhonghengParse {
    private val gson = Gson()
    fun search(json: String) =
        gson.fromJson(json, ChapterResponse::class.java).data?.datas?.list ?: emptyList()

    fun chapter(html: String) = mutableListOf<String>().apply {
        Jsoup.parse(html).select("#readerFt > div > div.reader_box > div.content > p").forEach {
            this += it.text().trim()
        }
    }

    fun catalogs(json: String) =
        gson.fromJson(json, CatalogResponse::class.java).result?.tomes?.get(0)?.chapter
            ?: emptyList()

    fun read(html: String) = Jsoup.parse(html)
        .select("body > div.wrap > div.book-html-box.clearfix > div.book-top.clearfix > div.book-main.fl > div.book-detail.clearfix > div.book-info > div.btn-group > a")
        .attr("href")
}
