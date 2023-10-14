package com.example.camera_monitoring.presentation.ui.cameras

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.camera_monitoring.data.repository.CameraRepositoryImpl
import com.example.camera_monitoring.domain.models.CameraModel
import com.example.camera_monitoring.domain.usecases.GetAllCamerasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
// `@HiltViewModel` - Эта аннотация говорит Dagger Hilt (инструмент для управления зависимостями), что этот класс является
//  ViewModel и он должен управлять зависимостями автоматически.
class CameraViewModel @Inject constructor(repositoryImpl: CameraRepositoryImpl) :
// Этот код описывает ViewModel, который используется для управления данными и бизнес-логикой связанной
// с камерами в Android-приложении.

// `class CameraViewModel @Inject constructor(repositoryImpl: CameraRepositoryImpl) : ViewModel()`:
// Это объявление класса `CameraViewModel`. Он расширяет класс `ViewModel` и принимает зависимость
// `repositoryImpl` через конструктор. Зависимость будет предоставлена Dagger'ом.
    ViewModel() {
    private val camerasUseCase = GetAllCamerasUseCase(repositoryImpl)

    // `private val camerasUseCase = GetAllCamerasUseCase(repositoryImpl)`:
    // Создается объект `camerasUseCase`, который представляет собой случай использования (use case)
    // для получения данных о камерах. Он использует `repositoryImpl` для работы с данными.
    val cameraList = MutableLiveData<List<CameraModel>>()

    init {
        getCameras()
    }

    private fun getCameras() {
        viewModelScope.launch {
            camerasUseCase.getResult().collect { response ->
                // `camerasUseCase.getResult().collect { response -> ... }`: Здесь используется `camerasUseCase`,
                // чтобы получить результат. Метод `getResult()` предположительно возвращает данные о камерах. Эти данные будут собраны в `response`.
                cameraList.postValue(response)
                Log.d("ololo", "getCameras: $response")
            }
        }
    }
}/*
В целом, этот класс предназначен для управления данными о камерах в приложении, включая их получение из репозитория
и обновление интерфейса при необходимости.
 */