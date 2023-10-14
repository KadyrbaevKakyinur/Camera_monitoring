package com.example.camera_monitoring.domain.models

data class DoorModel(
    val id: Int,
    val name: String = "Door",
    val image: String? = null,
    var isFavourite: Boolean = false
)