package com.example.book.model.chapter

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
data class RecDataList (
    var id: Long  = 0,
    var typeId :Int = 0,
    var position :Int = 0,
    var bookId: Long  = 0,
    var bookName: String? = null,
    var authorId: Long  = 0,
    var authorName: String? = null,
    var catePid :Int = 0,
    var cateId :Int = 0,
    var catePname: String? = null,
    var cateName: String? = null,
    var title: String? = null,
    var summary: String? = null,
    var imageUrl: String? = null,
    var linkUrl: String? = null,
    var titleColor: String? = null,
    var createTime: Date? = null,
    var issueTime: Date? = null,
    var updateTime: Date? = null,
    var description: String? = null,
    var recReason: String? = null,
    var serialStatus :Int = 0,
    var level :Int = 0,
    var totalWord: Long  = 0,
    var uniqCharId: String? = null,
    var beginTime: Date? = null,
    var endTime: Date? = null,
    var extraInfo: String? = null,
    var extraInfoJsonMap: String? = null,
)
