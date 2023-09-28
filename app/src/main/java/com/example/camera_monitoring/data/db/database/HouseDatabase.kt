package com.example.camera_monitoring.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.camera_monitoring.data.db.dao.CamerasDao
import com.example.camera_monitoring.data.db.dao.DoorsDao
import com.example.camera_monitoring.data.model.Camera
import com.example.camera_monitoring.data.model.Door

@Database(entities = [Camera::class, Door::class], version = 1, exportSchema = true)
abstract class HouseDatabase : RoomDatabase(){
    abstract fun getCameraDao(): CamerasDao
    abstract fun getDoorDao(): DoorsDao
}