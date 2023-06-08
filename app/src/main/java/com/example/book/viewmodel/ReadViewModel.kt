package com.example.book.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.book.request.OkHttpRequest
import com.example.book.thread.ThreadPool

class ReadViewModel: ViewModel() {
    val content = MutableLiveData<List<String>>()

    fun content(bookId: String, chapterId: String) {
        ThreadPool.submit{
            OkHttpRequest.content(bookId, chapterId).also {
                content.postValue(it)
            }
        }
    }
}