package com.example.camera_monitoring.domain.utils

sealed class Resource<T>(
    // sealed class в Kotlin - это специальный тип класса, который ограничивает возможные подклассы (или наследники) к определенному набору.
    val data: T? = null, val message: String? = null
) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T?) : Resource<T>()
    class Error<T>(message: String?) : Resource<T>()
}
