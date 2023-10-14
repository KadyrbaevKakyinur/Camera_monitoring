package com.example.camera_monitoring.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.camera_monitoring.data.model.Door

@Dao
interface DoorDao {
    @Query("SELECT * FROM door")

    suspend fun getAllDoors(): List<Door>

    @Insert
    suspend fun insertDoor(door: Door)

    @Update
    suspend fun updateDoor(door: Door)

    @Delete
    suspend fun deleteDoor(door: Door)
}