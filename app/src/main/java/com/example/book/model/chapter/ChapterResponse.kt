/**
 * Copyright 2023 json.cn
 */
package com.example.book.model.chapter

import com.example.book.util.printDataClassString

/**
 * Auto-generated: 2023-06-08 0:48:38
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
class ChapterResponse {
    var code = 0
    var data: Data? = null
    var message: String? = null
}

fun main() {
    """
        class ChapterResponse {
            var code = 0
            var data: Data? = null
            var message: String? = null
        }
        
    """.trimIndent().printDataClassString()
}