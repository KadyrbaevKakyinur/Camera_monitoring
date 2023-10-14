package com.example.camera_monitoring.presentation.ui.cameras

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.camera_monitoring.databinding.FragmentCameraBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CameraFragment : Fragment() {
    private lateinit var binding: FragmentCameraBinding
    private val adapter = CameraAdapter()
    private val cameraViewModel: CameraViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        addElements()
    }

    private fun addElements() {
        lifecycleScope.launch {
            cameraViewModel.cameraList.observe(requireActivity()) { response ->
                if (response != null) {
                    adapter.setList(response)
                }
                /*
                private fun addElements() {: Это определение функции с названием addElements. Функции нужны, чтобы собрать некоторый код вместе и вызывать его в нужные моменты.
lifecycleScope.launch {: Здесь начинается новая корутина. Корутины позволяют выполнять асинхронные операции, не блокируя основной поток приложения.
cameraViewModel.cameraList.observe(requireActivity()) { response ->: Эта строка означает, что мы наблюдаем за изменениями в списке камер, который хранится в cameraViewModel. Когда этот список обновляется, сработает блок кода внутри.
if (response != null) {: Здесь проверяется, что ответ не является пустым (то есть, что у нас есть какие-то данные).
adapter.setList(response): Если у нас есть данные, то мы передаем их в адаптер (предположительно, для отображения в пользовательском интерфейсе).
                 */
            }
        }
    }
}