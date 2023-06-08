package com.example.book.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.book.model.chapter.List1
import com.example.book.request.OkHttpRequest
import com.example.book.thread.ThreadPool

class SearchViewModel : ViewModel() {
    val books = MutableLiveData<List<List1>>()

    fun search(keyword: String) {
        ThreadPool.submit {
            books.postValue(
                OkHttpRequest.search(keyword)
            )
        }
    }
}