package com.example.book.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.book.databinding.ActivitySousuoBinding


class SousuoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySousuoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}