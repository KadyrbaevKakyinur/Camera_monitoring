package com.example.camera_monitoring.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.camera_monitoring.data.model.Camera

@Dao
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
