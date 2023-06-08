/**
 * Copyright 2023 json.cn
 */
package com.example.book.model.catalog

import com.example.book.util.printDataClassString

/**
 * Auto-generated: 2023-06-08 21:38:40
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
data class Book(
    var bookId: Long = 0,
    var dbName: String? = null,
    var name: String? = null,
    var firstLetter: String? = null,
    var catePid: Int = 0,
    var cateId: Int = 0,
    var authorId: Long = 0,
    var keyword: String? = null,
    var authorization: Int = 0,
    var serialStatus: Int = 0,
    var firstRelease: Int = 0,
    var level: Int = 0,
    var description: String? = null,
    var wishWord: String? = null,
    var coverUrl: String? = null,
    var catalogColumns: Int = 0,
    var status: Int = 0,
    var createTime: Long = 0,
    var updateTime: Long = 0,
    var lastTime: Long = 0,
    var auditingTime: Long = 0,
    var assessorId: Int = 0,
    var totalWord: Long = 0,
    var ext1: String? = null,
    var ext2: String? = null,
    var isfemale: Int = 0,
    var actor: String? = null,
    var publish: Boolean = false,
    var payType: Int = 0,
    var consumeType: Int = 0,
    var startChapterId: Int = 0,
    var cpId: Int = 0,
    var zhAuth: Int = 0,
    var xmAuth: Int = 0,
    var pseudonym: String? = null,
    var cateName: String? = null,
    var catePname: String? = null,
    var cpName: String? = null,
    var shieldPlat: Int = 0,
)

fun main() {
    """
class Tome {
    var tomeId: Long = 0
    var tomeNo = 0
    var tomeName: String? = null
    var bookId: Long = 0
    var createTime: Long = 0
    var updateTime: Long = 0
    var ext1: String? = null
    var ext2: String? = null
    var level = 0
    var tomeBrief: String? = null
}
        
    """.trimIndent().printDataClassString()
}