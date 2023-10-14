package com.example.camera_monitoring.data.utils

import com.example.camera_monitoring.data.model.Camera
import com.example.camera_monitoring.data.model.Door
import com.example.camera_monitoring.domain.models.CameraModel
import com.example.camera_monitoring.domain.models.DoorModel


//Этот код на Kotlin предоставляет функции для перевода информации о камерах и дверях из одного формата в другой.
fun List<Camera>.mapToCameraModel() = this.map { camera ->
    CameraModel(
        id = camera.id, name = camera.name, image = camera.image, isFavourite = camera.isFavourite
    )
}
//1. **`mapToCameraModel()`**: Это функция, которая принимает список камер и превращает каждую камеру в специальный формат,
// который называется `CameraModel`. Таким образом, у вас будет список камер, но в другом виде, где каждая камера представлена
// в виде `CameraModel`.
fun List<Door>.mapToDoorModel() = this.map { door ->
    DoorModel(
        id = door.id, name = door.name, image = door.image, isFavourite = door.isFavourite
    )
}
//2. **`mapToDoorModel()`**: Эта функция делает то же самое, что и первая, но для дверей.
// Она принимает список дверей и превращает их в формат `DoorModel`.
fun CameraModel.convertToCamera() = Camera(
    id = this.id, name = this.name, image = this.image, isFavourite = this.isFavourite
)

fun DoorModel.convertToDoor() = Door(
    id = this.id, name = this.name, image = this.image, isFavourite = this.isFavourite
)
