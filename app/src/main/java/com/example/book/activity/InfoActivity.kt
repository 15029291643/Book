package com.example.book.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.book.databinding.ActivityInfoBinding
import com.example.book.model.chapter.List1
import org.jsoup.Jsoup

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = intent.getSerializableExtra("list") as List1
        binding.name.text = list.name?.let {
            Jsoup.parse(it).text()
        }
        binding.description.text = list.description
        binding.keyword.text =
            list.keyword?.replace("、", " ")?.split(" ")?.take(3)?.joinToString(" ")
        binding.authorName.text = list.authorName
        list.coverUrl?.let {
            "https://static.zongheng.com/upload/$it"
        }?.also {
            Glide.with(this).load(it).into(binding.cover)
        }
        binding.read.setOnClickListener {
            Intent(this, ReadActivity::class.java).apply {
                putExtra("tomeId", list.tomeId)
            }.also {
                startActivity(it)
            }
        }
    }
}