package com.example.camera_monitoring.data.repository

import com.example.camera_monitoring.domain.models.CameraModel
import com.example.camera_monitoring.domain.repositories.CameraRepository


class CamerasRepository : CameraRepository {

    override suspend fun getAllCameras(): List<CameraModel> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCamera(camera: CameraModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCamera(camera: CameraModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCamera(camera: CameraModel) {
        TODO("Not yet implemented")
    }
}