package com.example.camera_monitoring.data.remote


import com.example.camera_monitoring.domain.models.CameraList
import com.example.camera_monitoring.domain.models.DoorList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras")
    suspend fun getCameras(): Response<CameraList>

    @GET("doors")
    fun getDoors(): Response<DoorList>
}