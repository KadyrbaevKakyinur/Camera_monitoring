package com.example.camera_monitoring.domain.models

data class DoorModel(
    val id: Int, val name: String?, val image: String?, var isFavorite: Boolean = false
)