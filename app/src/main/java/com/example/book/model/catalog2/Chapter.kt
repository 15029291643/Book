/**
 * Copyright 2023 json.cn
 */
package com.example.book.model.catalog2

/**
 * Auto-generated: 2023-06-07 21:17:42
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
// 为了统一两种格式，删除其中一个

data class Chapter(
    var level: Int = 0,
    var chapterId: Long = 0,
    var chapterName: String? = null,
    var wordNum: Int = 0,
    var newChapter: Boolean = false,
)
