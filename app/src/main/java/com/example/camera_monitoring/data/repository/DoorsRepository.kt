package com.example.camera_monitoring.data.repository

import com.example.camera_monitoring.domain.models.DoorModel
import com.example.camera_monitoring.domain.repositories.DoorRepository


class DoorsRepository : DoorRepository {
    override suspend fun getAllDoors(): List<DoorModel> {
        TODO("Not yet implemented")
    }

    override suspend fun insertDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }
}