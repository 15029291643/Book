package com.example.book.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.book.activity.InfoActivity
import com.example.book.databinding.AdapterResultBinding
import com.example.book.model.chapter.List1
import org.jsoup.Jsoup

class ResultAdapter(
    private val acitvity: Activity
) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    val list = mutableListOf<List1>()

    class ViewHolder(val binding: AdapterResultBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imageView
        val name = binding.textView
        val table = binding.textView2
        val info = binding.textView3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name?.let {
            Jsoup.parse(it).text()
        }
        holder.itemView.setOnClickListener {
            acitvity.startActivity(Intent(acitvity, InfoActivity::class.java))
        }
    }
}

