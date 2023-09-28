package com.example.camera_monitoring.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.camera_monitoring.data.model.Door

@Dao
interface DoorsDao {
    @Query("SELECT * FROM doors")
    suspend fun getAllDoors(): List<Door>

    @Insert
    suspend fun insertDoor(door: Door): Unit

    @Update
    suspend fun updateDoor(door: Door): Unit

    @Delete
    suspend fun deleteDoor(door: Door): Unit
}