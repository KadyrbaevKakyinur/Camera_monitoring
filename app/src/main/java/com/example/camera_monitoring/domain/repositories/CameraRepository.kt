package com.example.camera_monitoring.domain.repositories

import com.example.camera_monitoring.domain.models.CameraModel


interface CameraRepository {
    suspend fun getAllCameras(): List<CameraModel>
    suspend fun insertCamera(camera: CameraModel)
    suspend fun updateCamera(camera: CameraModel)
    suspend fun deleteCamera(camera: CameraModel)
}