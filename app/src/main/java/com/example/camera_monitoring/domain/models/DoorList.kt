package com.example.camera_monitoring.domain.models

data class DoorList(
    var data: DoorData
)

data class DoorData(
    var doors: List<DoorModel>
)