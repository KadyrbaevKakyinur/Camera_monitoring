package com.example.camera_monitoring.domain.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class CameraModel(
    @PrimaryKey val id: Int,
    val name: String = "Camera",
    @SerializedName("snapshot") val image: String? = null,
    var isFavourite: Boolean = false
)
