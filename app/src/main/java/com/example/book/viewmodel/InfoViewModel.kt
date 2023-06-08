package com.example.book.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.book.model.catalog.ChapterViewList
import com.example.book.model.catalog2.Chapter
import com.example.book.request.OkHttpRequest
import com.example.book.thread.ThreadPool

class InfoViewModel : ViewModel() {
    val chapters = MutableLiveData<List<ChapterViewList>>()
    val chapters2 = MutableLiveData<List<Chapter>>()

    fun chapter(bookId: String) {
        ThreadPool.submit {
            chapters.postValue(OkHttpRequest.catalogs(bookId))
        }
        ThreadPool.submit {
            chapters2.postValue(OkHttpRequest.catalogs2(bookId))
        }
    }
}