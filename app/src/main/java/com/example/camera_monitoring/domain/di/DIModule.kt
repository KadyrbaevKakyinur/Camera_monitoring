package com.example.camera_monitoring.domain.di

import android.content.Context
import androidx.room.Room
import com.example.camera_monitoring.data.db.dao.CameraDao
import com.example.camera_monitoring.data.db.dao.DoorDao
import com.example.camera_monitoring.data.db.database.HouseDatabase
import com.example.camera_monitoring.data.repository.CameraRepositoryImpl
import com.example.camera_monitoring.data.repository.DoorRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
//`@Module`: Объявляет этот класс как Dagger-модуль. Dagger использует модули для предоставления зависимостей.
@InstallIn(SingletonComponent::class)
//Эта аннотация указывает, в каком компоненте Dagger следует установить этот модуль.
//В данном случае, модуль устанавливается в `SingletonComponent`, что означает, что
//его зависимости будут жить в течение всего жизненного цикла приложения.
object DIModule {
    //   - Это объект-модуль, который содержит методы, предоставляющие зависимости.
    @Singleton
    @Provides
    //   - `@Singleton` означает, что результат, возвращенный этим методом, будет предоставлен как синглтон (один экземпляр для всего приложения).
    //   - `@Provides` аннотация используется для пометки методов, которые предоставляют зависимости.
    fun provideRoomDatabase(@ApplicationContext context: Context): HouseDatabase {
        return Room.databaseBuilder(
            context = context, klass = HouseDatabase::class.java, "house_database"
        ).build()
    }

    //   - Этот метод предоставляет объект `HouseDatabase`, который является базой данных Room для приложения.
//   Он принимает контекст приложения как параметр.
//   - В этой строке кода происходит построение базы данных Room с именем "house_database".
    @Provides
    fun provideCameraDao(roomDatabase: HouseDatabase): CameraDao {
        return roomDatabase.getCameraDao()
    }

    //   **fun provideCameraDao(roomDatabase: HouseDatabase): CameraDao**:
//   - Этот метод предоставляет объект `CameraDao`, который является интерфейсом для работы с данными камеры в базе данных.
    @Provides
    fun provideDoorDao(roomDatabase: HouseDatabase): DoorDao {
        return roomDatabase.getDoorDao()
    }

    //   **fun provideDoorDao(roomDatabase: HouseDatabase): DoorDao**:
//   - Аналогично предыдущему методу, этот предоставляет объект `DoorDao`, который представляет интерфейс для работы с данными двери в базе данных.
    @Provides
    fun provideCameraRepository(
        cameraDao: CameraDao
    ): CameraRepositoryImpl = CameraRepositoryImpl(cameraDao)

    //   **fun provideCameraRepository(cameraDao: CameraDao): CameraRepositoryImpl**:
//    - Этот метод предоставляет репозиторий `CameraRepositoryImpl`, который использует `CameraDao` для выполнения операций с данными камеры.
    @Provides
    fun provideDoorRepository(
        doorDao: DoorDao
    ): DoorRepositoryImpl = DoorRepositoryImpl(doorDao)
}
