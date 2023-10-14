package com.example.camera_monitoring.domain.usecases

import com.example.camera_monitoring.data.repository.CameraRepositoryImpl
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val repository: CameraRepositoryImpl
) {
     suspend fun getAllDoors() = repository.getAllCameras()

    suspend fun getResult() = repository.getResult()
}
