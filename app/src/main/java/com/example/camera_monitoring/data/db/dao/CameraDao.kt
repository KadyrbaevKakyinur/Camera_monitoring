package com.example.camera_monitoring.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.camera_monitoring.data.model.Camera

@Dao
//1. `@Dao`: Это аннотация, которая говорит компилятору, что этот интерфейс представляет собой объект доступа к данным (Data Access Object).
interface CameraDao {
    @Query("SELECT * FROM camera")


    suspend fun getAllCameras(): List<Camera>

    @Insert
    suspend fun insertCamera(camera: Camera)

    @Update
    suspend fun updateCamera(camera: Camera)

    @Delete
    suspend fun deleteCamera(camera: Camera)
}
