package com.example.camera_monitoring.data.remote

import com.example.camera_monitoring.data.model.Camera
import com.example.camera_monitoring.data.model.Door
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/cameras")
    fun getCameras(): Call<Camera>

    @GET("/doors")
    fun getDoors(): Call<Door>
}