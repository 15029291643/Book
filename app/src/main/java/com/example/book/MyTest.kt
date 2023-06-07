package com.example.book

import com.example.book.request.FanqieRequest

val url = """


http://search.zongheng.com/search/book?keyword=%E8%A2%AB%E5%8A%A8%E6%8A%80%E8%83%BD&sort=null&pageNo=1&pageNum=20&isFromHuayu=0

    """

fun main() {
    val url = "https://naodongapi.zongheng.com/planet/book/catalogs"
    val json = "{\"bookId\":1245784}"
    val post = FanqieRequest.post(url, json)
    println(post)
}


fun parseUrl(url: String) = url
    .replace(" ", "")
    .replace("\n", "")
    .replace("?", "?\n")
    .replace("&", "\n&")