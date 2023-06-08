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
data class ShowTomeViewList (
    var tome: Tome? = null,
    var startChapterId: Long = 0,
    var chapterViewList: List<ChapterViewList>? = null,
    var tomeTotalWords: Long = 0,
    var tomeTotalChapterNum :Int = 0,
)