package com.example.camera_monitoring.presentation.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.camera_monitoring.presentation.ui.cameras.CamerasFragment
import com.example.camera_monitoring.presentation.ui.doors.DoorsFragment
import com.example.camera_monitoring.presentation.ui.favorites.FavoritesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CamerasFragment()
            1 -> DoorsFragment()
            2 -> FavoritesFragment()
            else -> Fragment()
        }
    }
}