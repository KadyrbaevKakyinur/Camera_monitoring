package com.example.camera_monitoring.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.camera_monitoring.databinding.ActivityMainBinding
import com.example.camera_monitoring.presentation.ui.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
// `@AndroidEntryPoint` - это аннотация, используемая в связке с библиотекой Dagger Hilt.
// Она указывает, что этот компонент (в данном случае, активити) должен быть внедрен Dagger'ом.
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

    // `private val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)` - Создается объект `ViewPagerAdapter`,
    // который используется для управления фрагментами внутри активити.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        val arrayNumbers = listOf(1, 2, 3, 4, 5, 6)
        arrayNumbers.filter { it % 2 == 0 }
        // `arrayNumbers.filter { it % 2 == 0 }` - Этот код фильтрует числа в списке, оставляя только четные.
        val a = 0.0f
        arrayNumbers.map {
            9
            // `arrayNumbers.map { 9 }` - Этот код преобразует каждый элемент списка в число 9.
        }
    }

    private fun initViews() {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val toolbar = binding.toolbar
        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = CAMERA_TITLE
                1 -> tab.text = DOOR_TITLE
                2 -> tab.text = FAVOURITES_TITLE
            }
            // `TabLayoutMediator(tabLayout, viewPager) { tab, position -> ... }` - Этот код связывает вкладки (tabLayout)
            // с ViewPager, определяя, что отображать в каждой вкладке.
        }.attach()
        setSupportActionBar(toolbar)
        // `setSupportActionBar(toolbar)` - Устанавливает тулбар (верхнюю панель) как действующее действие (action bar).
        supportActionBar?.setDisplayShowTitleEnabled(false)
        // `supportActionBar?.setDisplayShowTitleEnabled(false)` - Скрывает заголовок по умолчанию в тулбаре.
        binding.toolbarTitle.text = TOOLBAR_TITLE
    }

    companion object {
        const val CAMERA_TITLE = "Камеры"
        const val DOOR_TITLE = "Двери"
        const val FAVOURITES_TITLE = "Избранные"
        const val TOOLBAR_TITLE = "Мой дом"
    }
}/*
Этот код представляет собой основную логику активити в Android-приложении, включая инициализацию пользовательского интерфейса и обработку событий.
 */