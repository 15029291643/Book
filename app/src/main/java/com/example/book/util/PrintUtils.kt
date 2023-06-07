package com.example.book.util

fun String.printlnWithAlso(s: String) = also {
    println("$it: $s")
}

fun String.println(s: String) {
    println("$this: $s")
}


fun Any.printlnWithAlso(s: String) = also {
    println("$it: $s")
}