package com.example.book.model.chapter

import java.io.Serializable
import java.util.Date

/**
 * Copyright 2023 json.cn
 */
/**
 * Auto-generated: 2023-06-07 19:34:12
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
data class List1(
    var bookId: Long = 0,
    var name: String? = null,
    var coverUrl: String? = null,
    var authorization: Int = 0,
    var serialStatus: Int = 0,
    var keyword: String? = null,
    var catePid: Int = 0,
    var catePName: String? = null,
    var cateId: Int = 0,
    var authorId: Long = 0,
    var authorName: String? = null,
    var tomeId: Long = 0,
    var tomeName: String? = null,
    var chapterId: Long = 0,
    var chapterName: String? = null,
    var updateTime: Date? = null,
    var level: Int = 0,
    var description: String? = null,
    var cpId: Int = 0,
    var cpName: String? = null,
    var consumeType: Int = 0,
    var totalWord: Long = 0,
) : Serializable