package com.example.camera_monitoring.domain.usecases

import com.example.camera_monitoring.data.repository.DoorRepositoryImpl
import javax.inject.Inject

class GetAllDoorsUseCase @Inject constructor(
    private val repository: DoorRepositoryImpl
) {
    suspend fun getAllDoors() = repository.getAllDoors()
}