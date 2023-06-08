package com.example.book.request

import com.example.book.model.catalog.CatalogResponse
import com.example.book.model.catalog2.CatalogResponse2
import com.example.book.model.chapter.ChapterResponse
import com.example.book.util.logeOrPrintln
import com.google.gson.Gson
import org.jsoup.Jsoup

object ZhonghengParse {
    private val gson = Gson()
    fun search(json: String) =
        gson.fromJson(json, ChapterResponse::class.java).data?.datas?.list ?: emptyList()

    fun content(html: String) = mutableListOf<String>().apply {
        Jsoup.parse(html).select("#readerFt > div > div.reader_box > div.content > p").forEach {
            this += it.text().trim()
        }
    }

    // 解析目录
    fun catalogs(json: String) = try {
        gson.fromJson(
            json,
            CatalogResponse::class.java
        ).data?.showTomeViewList?.get(0)?.chapterViewList.also {
            "解析成功: ${it?.size}".logeOrPrintln()
        } ?: emptyList()
    } catch (_: Exception) {
        emptyList()
    }

    // 解析目录2
    fun catalogs2(json: String) = try {
        gson.fromJson(json, CatalogResponse2::class.java).result?.tomes?.get(0)?.chapter.also {
            "解析成功: ${it?.size}".logeOrPrintln()
        } ?: emptyList()
    } catch (_: Exception) {
        emptyList()
    }
}
