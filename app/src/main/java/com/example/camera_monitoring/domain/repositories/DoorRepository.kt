package com.example.camera_monitoring.domain.repositories

import com.example.camera_monitoring.domain.models.DoorModel
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getAllDoors(): Flow<com.example.camera_monitoring.domain.utils.Resource<List<DoorModel>>>

    suspend fun getResult(): Flow<List<DoorModel>>

    suspend fun insertDoor(door: DoorModel)

    suspend fun updateDoor(door: DoorModel)

    suspend fun deleteDoor(door: DoorModel)
}