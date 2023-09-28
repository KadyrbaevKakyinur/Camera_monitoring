package com.example.camera_monitoring.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doors")
data class Door(
    @PrimaryKey
    val id: Int,
    val name: String = "Door",
    val image: String ?= null,
    var isFavourite : Boolean = false
)