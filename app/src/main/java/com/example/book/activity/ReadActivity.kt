package com.example.book.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.book.databinding.ActivityReadBinding
import com.example.book.viewmodel.ReadViewModel

class ReadActivity : AppCompatActivity() {
    companion object {
        private lateinit var bookId: String
        private lateinit var chapterId: String
        fun putExtra(bookId: String, chapterId: String) {
            this.bookId = bookId
            this.chapterId = chapterId
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[ReadViewModel::class.java]
        viewModel.content(bookId, chapterId)
        viewModel.content.observe(this) { list ->
            binding.content.text = StringBuilder().apply {
                list.forEach {
                    append("    $it\n\n")
                }
            }
        }
    }
}