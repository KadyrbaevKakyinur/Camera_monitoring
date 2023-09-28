package com.example.camera_monitoring.presentation.ui.doors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.camera_monitoring.databinding.FragmentDoorBinding

class DoorsFragment : Fragment() {
    private lateinit var binding: FragmentDoorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorBinding.inflate(layoutInflater)
        return binding.root
    }
}