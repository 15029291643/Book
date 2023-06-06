package com.example.book.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.book.databinding.FragmentFeileiBinding

class FeileiFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFeileiBinding.inflate(inflater, container, false)
        return binding.root/*
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feilei, container, false)*/
    }
}