package com.example.book.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.book.activity.ReadActivity
import com.example.book.databinding.AdapterCatalogBinding
import com.example.book.model.catalog.ChapterViewList

class CatalogAdapter(val activity: Activity) :
    RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {
    val list = mutableListOf<ChapterViewList>()
    lateinit var bookId: String

    class ViewHolder(binding: AdapterCatalogBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.textView2
        val t2 = binding.textView3
        val t3 = binding.textView7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].chapterName
        // 打开章节阅读
        holder.itemView.setOnClickListener {
            ReadActivity.putExtra(
                list[position].bookId.toString(),
                list[position].chapterId.toString()
            )
            activity.startActivity(Intent(activity, ReadActivity::class.java))
        }
    }
}