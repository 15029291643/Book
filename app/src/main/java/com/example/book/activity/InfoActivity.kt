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
import com.example.book.viewmodel.InfoViewModel
import org.jsoup.Jsoup

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[InfoViewModel::class.java]

        val book = intent.getSerializableExtra("list") as List1
        binding.name.text = book.name?.let {
            Jsoup.parse(it).text()
        }
        binding.description.text = book.description
        binding.keyword.text =
            book.keyword?.replace("、", " ")?.split(" ")?.take(3)?.joinToString(" ")
        binding.authorName.text = book.authorName
        book.coverUrl?.let {
            "https://static.zongheng.com/upload/$it"
        }?.also {
            Glide.with(this).load(it).into(binding.cover)
        }
        // 打开第一章
        binding.read.setOnClickListener {
            viewModel.chapters.value?.let { chapters ->
                ReadActivity.putExtra(
                    book.tomeId.toString(),
                    chapters[0].chapterId.toString()
                )
                startActivity(Intent(this, ReadActivity::class.java))
            }
        }

        // 目录
        binding.catalogs.layoutManager = LinearLayoutManager(this)
        val adapter = CatalogAdapter(this, book.tomeId.toString())
        binding.catalogs.adapter = adapter

        viewModel.chapters.observe(this) {
            adapter.list.clear()
            adapter.list.addAll(it)
            adapter.notifyDataSetChanged()
        }

        viewModel.chapter(book.bookId.toString())
    }
}