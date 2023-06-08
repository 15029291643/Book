package com.example.book.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.book.adapter.CatalogAdapter
import com.example.book.databinding.ActivityInfoBinding
import com.example.book.model.chapter.List1
import com.example.book.util.logeOrPrintln
import com.example.book.viewmodel.InfoViewModel
import org.jsoup.Jsoup

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[InfoViewModel::class.java]

        val list = intent.getSerializableExtra("list") as List1
        list.toString().logeOrPrintln()
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

        // 目录
        binding.catalogs.layoutManager = LinearLayoutManager(this)
        val adapter = CatalogAdapter(this)
        binding.catalogs.adapter = adapter

        viewModel.chapters.observe(this) {
            adapter.list.clear()
            adapter.list.addAll(it)
            adapter.notifyDataSetChanged()
        }

        viewModel.chapter(list.bookId.toString())
    }
}