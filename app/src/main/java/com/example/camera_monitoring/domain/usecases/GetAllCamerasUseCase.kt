package com.example.camera_monitoring.domain.usecases

import com.example.camera_monitoring.data.repository.CameraRepositoryImpl
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val repository: CameraRepositoryImpl
) {
    //`class GetAllCamerasUseCase @Inject constructor(private val repository: CameraRepositoryImpl)`: Эта строка объявляет класс
    // `GetAllCamerasUseCase`. В его конструктор передается `CameraRepositoryImpl` в качестве зависимости.
    //  Dagger будет предоставлять эту зависимость при создании экземпляра этого класса.
    suspend fun getAllDoors() = repository.getAllCameras()

    //`suspend fun getAllDoors() = repository.getAllCameras()`: Этот метод, вероятно, предназначен для получения всех камер.
    // Он помечен как `suspend`, что означает, что его можно вызвать из корутины.
    suspend fun getResult() = repository.getResult()
}
    //`suspend fun getResult() = repository.getResult()`: Этот метод, вероятно, предназначен для получения результата из репозитория.
    // Как и предыдущий метод, он также помечен как `suspend`.
/*
 В общем, этот класс `GetAllCamerasUseCase` выступает в качестве прослойки между пользовательским интерфейсом и репозиторием,
 предоставляя методы для выполнения операций, связанных с камерами, и, вероятно, обработки их результатов.
 */