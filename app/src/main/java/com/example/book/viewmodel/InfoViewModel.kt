package com.example.book.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.book.model.catalog.Chapter
import com.example.book.request.OkHttpRequest
import com.example.book.thread.ThreadPool

class InfoViewModel : ViewModel() {
    val chapters = MutableLiveData<List<Chapter>>()

    fun chapter(bookId: String) {
        ThreadPool.submit {
            chapters.postValue(OkHttpRequest.catalogs(bookId))
        }
    }
}