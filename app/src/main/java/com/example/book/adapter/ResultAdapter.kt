package com.example.book.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.book.activity.InfoActivity
import com.example.book.databinding.AdapterResultBinding
import com.example.book.model.chapter.List1
import org.jsoup.Jsoup

class ResultAdapter(
    private val acitvity: Activity
) : RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    val list = mutableListOf<List1>()

    class ViewHolder(val binding: AdapterResultBinding) : RecyclerView.ViewHolder(binding.root) {
        // /cover/3c/39/3c390092ee7f1c2e12f9feb44c0b6dfe.jpeg
        val cover = binding.imageView
        val name = binding.textView
        val description = binding.description
        val authorName = binding.authorName
        val keyword = binding.keyword
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
        holder.description.text = list[position].description
        holder.keyword.text =
            list[position].keyword?.replace("、", " ")?.split(" ")?.take(3)?.joinToString(" ")
        holder.authorName.text = list[position].authorName
        list[position].coverUrl?.let {
            "https://static.zongheng.com/upload/$it"
        }?.also {
            Glide.with(acitvity).load(it).into(holder.cover)
        }
        holder.itemView.setOnClickListener {
            Intent(acitvity, InfoActivity::class.java).apply {
                putExtra("list", list[position])
            }.also {
                acitvity.startActivity(it)
            }
        }
    }
}

