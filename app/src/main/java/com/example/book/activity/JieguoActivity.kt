package com.example.book.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.book.adapter.ResultAdapter
import com.example.book.databinding.ActivityJieguoBinding
import com.example.book.request.OkHttpRequest
import com.example.book.util.loge
import com.example.book.viewmodel.SearchViewModel

class JieguoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityJieguoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        Thread {
            loge(OkHttpRequest.search("斗罗").toString())
        }.start()


        val adapter = ResultAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        viewModel.books.observe(this) {
            adapter.list.replaceAll {
                it.also {
                    toString().loge()
                }
            }
            adapter.notifyDataSetChanged()
        }
        binding.button.setOnClickListener {
            "点击".loge()
            viewModel.search(
//                binding.editTextText.text.toString()
                "被动"
            )
        }
    }
}