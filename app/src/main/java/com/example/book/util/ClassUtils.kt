package com.example.book.util


fun String.toDataClassString() = "data ${trim()}"
    .replace("{", "(")
    .replace("}", ")")
    .replace("\n", ",\n")
    .replace("= 0", ":Int = 0")
    .replace("= false", ":Boolean = false")
    .replace("= \"\"", ":String = \"\"")
    .replace("Long :Int", "Long")
    .replace("(,", "(")

fun String.printDataClassString() = println(toDataClassString())