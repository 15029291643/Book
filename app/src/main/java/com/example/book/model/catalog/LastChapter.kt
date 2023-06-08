/**
 * Copyright 2023 json.cn
 */
package com.example.book.model.catalog

/**
 * Auto-generated: 2023-06-08 21:38:40
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
data class LastChapter (
    var tomeId: Long = 0,
    var tomeName: String? = null,
    var chapterId: Long = 0,
    var chapterName: String? = null,
    var wordNum :Int = 0,
    var createTime: Long = 0,
    var price :Int = 0,
    var status :Int = 0,
    var level :Int = 0,
    var bookId: Long = 0,
    var everBuy :Boolean = false,
    var newChapter :Boolean = false,
    var contentType :Int = 0,
)