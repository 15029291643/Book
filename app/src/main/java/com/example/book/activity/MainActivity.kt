package com.example.book.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.book.R
import com.example.book.databinding.ActivityMainBinding
import com.example.book.fragment.FeileiFragment
import com.example.book.fragment.ShuchengFragment
import com.example.book.fragment.ShujiaFragment
import com.example.book.fragment.WodeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var shujiaFragment: Fragment
    private lateinit var feileiFragment: Fragment
    private lateinit var shuchengFragment: Fragment
    private lateinit var wodeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        shujiaFragment = ShujiaFragment()
        feileiFragment = FeileiFragment()
        shuchengFragment = ShuchengFragment()
        wodeFragment = WodeFragment()
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.shucheng -> shuchengFragment
                R.id.fenlei -> feileiFragment
                R.id.shujia -> shujiaFragment
                R.id.wode -> wodeFragment
                else -> shujiaFragment
            }.let {
                replaceFragment(it)
            }
            true
        }
        replaceFragment(shuchengFragment)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.frameLayout.id, fragment).commit()
    }
}