package com.example.book.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.book.databinding.AdapterHotBinding

class HotAdapter(
    private val activity: Activity
) : RecyclerView.Adapter<HotAdapter.ViewHolder>() {
    class ViewHolder(val binding: AdapterHotBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imageView2
        val no = binding.textView4
        val name = binding.textView5
        val info = binding.textView6
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterHotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}