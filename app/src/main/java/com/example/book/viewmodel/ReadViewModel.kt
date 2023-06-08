package com.example.book.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.book.request.OkHttpRequest
import com.example.book.thread.ThreadPool

class ReadViewModel: ViewModel() {
    val content = MutableLiveData<String>()

    fun read(tomeId: String) {
        ThreadPool.submit{
            OkHttpRequest.read(tomeId).also {
                content.postValue(it)
            }
        }
    }
}