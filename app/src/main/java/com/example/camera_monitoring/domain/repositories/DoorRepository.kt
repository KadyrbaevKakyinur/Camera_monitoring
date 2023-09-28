package com.example.camera_monitoring.domain.repositories

import com.example.camera_monitoring.domain.models.DoorModel

interface DoorRepository {
    suspend fun getAllDoors(): List<DoorModel>
    suspend fun insertDoor(door: DoorModel)
    suspend fun updateDoor(door: DoorModel)
    suspend fun deleteDoor(door: DoorModel)
}