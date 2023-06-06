package com.example.book.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.book.adapter.HotAdapter
import com.example.book.databinding.FragmentShuchengBinding


class ShuchengFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentShuchengBinding.inflate(inflater, container, false)
        val adapter = HotAdapter(requireActivity())
        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 4, RecyclerView.HORIZONTAL, false)
        binding.recycler.adapter = adapter
        return binding.root
    }
}