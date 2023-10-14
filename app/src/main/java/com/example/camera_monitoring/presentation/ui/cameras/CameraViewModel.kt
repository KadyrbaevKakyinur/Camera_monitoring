package com.example.camera_monitoring.presentation.ui.cameras

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.camera_monitoring.data.repository.CameraRepositoryImpl
import com.example.camera_monitoring.domain.models.CameraModel
import com.example.camera_monitoring.domain.usecases.GetAllCamerasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(repositoryImpl: CameraRepositoryImpl) :
 ViewModel() {
    private val camerasUseCase = GetAllCamerasUseCase(repositoryImpl)

    val cameraList = MutableLiveData<List<CameraModel>>()

    init {
        getCameras()
    }

    private fun getCameras() {
        viewModelScope.launch {
            camerasUseCase.getResult().collect { response ->
               cameraList.postValue(response)
                Log.d("ololo", "getCameras: $response")
            }
        }
    }
}