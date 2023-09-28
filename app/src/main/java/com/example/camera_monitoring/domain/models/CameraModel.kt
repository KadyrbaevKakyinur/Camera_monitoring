package com.example.camera_monitoring.domain.models

data class CameraModel(
    val id: Int,
    val name: String?,
    val image: String?,
    var isFavourite: Boolean = false
)
