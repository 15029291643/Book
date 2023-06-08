package com.example.book.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.book.databinding.ActivityReadBinding
import com.example.book.viewmodel.ReadViewModel

class ReadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[ReadViewModel::class.java]
        intent.getStringExtra("tomeId")?.also {
            viewModel.read(it)
        }
        viewModel.content.observe(this) {
            binding.content.text = it
        }
    }
}