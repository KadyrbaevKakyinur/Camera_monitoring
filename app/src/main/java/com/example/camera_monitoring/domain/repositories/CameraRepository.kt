package com.example.camera_monitoring.domain.repositories

import com.bumptech.glide.load.engine.Resource
import com.example.camera_monitoring.domain.models.CameraModel
import kotlinx.coroutines.flow.Flow


interface CameraRepository {

    suspend fun getAllCameras(): Flow<com.example.camera_monitoring.domain.utils.Resource<List<CameraModel>>>

    suspend fun getResult(): Flow<List<CameraModel>>

    suspend fun insertCamera(camera: CameraModel)

    suspend fun updateCamera(camera: CameraModel)

    suspend fun deleteCamera(camera: CameraModel)
}