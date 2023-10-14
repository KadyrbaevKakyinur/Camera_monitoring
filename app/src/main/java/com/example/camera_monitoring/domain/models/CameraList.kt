package com.example.camera_monitoring.domain.models

data class CameraList(
    var data: CameraData
)

data class CameraData(
    var cameras: List<CameraModel>
)

