package com.example.camera_monitoring.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.camera_monitoring.R
import com.example.camera_monitoring.databinding.ActivityMainBinding
import com.example.camera_monitoring.presentation.ui.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        initializeView()
    }

    private fun initializeView() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val toolbar = binding.toolbar
        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Камеры"
                1 -> tab.text = "Двери"
                2 -> tab.text = "Избранные"
            }
        }.attach()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarTitle.text = "Мой дом"
    }
}