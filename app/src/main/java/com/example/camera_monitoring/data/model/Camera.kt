package com.example.camera_monitoring.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cameras")
data class Camera(
    @PrimaryKey
    val id: Int,
    val name: String = "Camera",
    val image: String ?= null,
    var isFavourite : Boolean = false
)
