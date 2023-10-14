package com.example.camera_monitoring.presentation.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.camera_monitoring.presentation.ui.cameras.CameraFragment
import com.example.camera_monitoring.presentation.ui.doors.DoorFragment
import com.example.camera_monitoring.presentation.ui.favorites.FavouritesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CameraFragment()
            1 -> DoorFragment()
            2 -> FavouritesFragment()
            else -> Fragment()
        }
    }
}