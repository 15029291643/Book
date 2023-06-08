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
data class Tomes(
    var tomeId: Long = 0,
    var name: String? = null,
    var level: Int = 0,
    var totalChapterNum: Int = 0,
    var totalWords: Long = 0,
    var chapter: List<Chapter>? = null,
)
