package com.example.camera_monitoring.data.repository


import com.example.camera_monitoring.data.db.dao.CameraDao
import com.example.camera_monitoring.data.retrofit.RetrofitService
import com.example.camera_monitoring.data.utils.convertToCamera
import com.example.camera_monitoring.data.utils.mapToCameraModel
import com.example.camera_monitoring.domain.models.CameraModel
import com.example.camera_monitoring.domain.repositories.CameraRepository
import com.example.camera_monitoring.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(

    private val cameraDao: CameraDao
) : CameraRepository {
    //CameraRepositoryImpl - это класс, который реализует интерфейс CameraRepository. Этот интерфейс, вероятно, описывает методы для взаимодействия с данными о камерах.
//@Inject constructor(private val cameraDao: CameraDao) - это конструктор класса. Он использует внедрение зависимостей
//(Dagger или другие инструменты внедрения зависимостей) для предоставления cameraDao, который предполагается,
//что будет использоваться для взаимодействия с базой данных.
    override suspend fun getAllCameras(): Flow<Resource<List<CameraModel>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = cameraDao.getAllCameras().mapToCameraModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Message is empty"))
            }
        }
    }

    /*
    override suspend fun getAllCameras(): Flow<Resource<List<CameraModel>>> - это метод для получения списка камер.
    Он возвращает Flow<Resource<List<CameraModel>>>, что позволяет асинхронно получать результаты.
    flow { ... } - это создание flow, который позволяет асинхронно генерировать результаты.
    emit(Resource.Loading()) - перед отправкой результата, он сначала отправляет состояние "загрузка".
    try { ... } catch (e: Exception) { ... } - это блок try-catch для обработки исключений, которые могут возникнуть при получении данных из cameraDao.
    val data = cameraDao.getAllCameras().mapToCameraModel() - здесь получаются данные о камерах из базы данных и преобразуются в модели камер.
    emit(Resource.Success(data)) - если данные успешно получены, они отправляются как успешный результат.
    emit(Resource.Error(e.message ?: "Message is empty")) - если произошла ошибка, отправляется сообщение об ошибке.
     */
    override suspend fun getResult(): Flow<List<CameraModel>> {
        return flow {
            val data = RetrofitService.apiService.getCameras().body()?.data?.cameras
            if (data != null) {
                emit(data)
            }
        }/*
        Функция getResult():
        override suspend fun getResult(): Flow<List<CameraModel>>: Эта функция представляет собой метод, который возвращает данные в виде потока
        (Flow) объектов, представляющих список моделей камер (CameraModel).
        return flow { ... }: Здесь создается новый поток, который будет использоваться для передачи данных.
        val data = RetrofitService.apiService.getCameras().body()?.data?.cameras: В этой строке выполняется запрос к удаленному серверу (предположительно, получение данных о камерах) с использованием Retrofit, а затем извлекаются данные из ответа.
        if (data != null) { emit(data) }: Если данные успешно получены (то есть data не равно null), то они будут отправлены (излучены) через поток.
         */
    }
    // emit - это функция в Kotlin, которая используется для отправки (или "излучения") элемента в Flow

    override suspend fun insertCamera(camera: CameraModel) {
        cameraDao.insertCamera(camera.convertToCamera())
    }
    //Функция insertCamera(camera: CameraModel):
    //override suspend fun insertCamera(camera: CameraModel): Эта функция принимает аргументом объект camera типа CameraModel и выполняет операцию вставки этой камеры в базу данных (предположительно, локальную).
    //cameraDao.insertCamera(camera.convertToCamera()): Здесь используется cameraDao (предположительно, это объект доступа к данным), чтобы выполнить операцию вставки.

    override suspend fun updateCamera(camera: CameraModel) {
        cameraDao.updateCamera(camera.convertToCamera())
    }

    override suspend fun deleteCamera(camera: CameraModel) {
        cameraDao.deleteCamera(camera.convertToCamera())
    }
}/*
`Flow` - это новый компонент Kotlin, предоставляющий асинхронный поток данных, который может эффективно обрабатываться
 в асинхронных операциях. Он является частью Kotlin Coroutines и предоставляет альтернативу использованию колбеков или RxJava
 для работы с асинхронными операциями.
 Основные характеристики `Flow`:
1. **Асинхронность**: Позволяет асинхронно генерировать и потреблять данные.
2. **Ленивость**: Потоки начинают генерировать данные только тогда, когда они начинают быть потребителями.
 Это позволяет избегать затрат на вычисления, если результат не нужен.
3. **Композиция**: Позволяет комбинировать и объединять потоки, делая их мощным инструментом для обработки данных.
4. **Отмена**: Потоки умеют корректно обрабатывать сценарии отмены, что делает их прекрасным выбором для долгих операций.
5. **Error Handling**: Предоставляет удобные средства для обработки ошибок в асинхронных операциях.
Пример использования `Flow` в асинхронном программировании:
fun fetchUserData(): Flow<Result<User>> = flow {
    emit(Result.Loading)
    try {
        val user = fetchUserFromNetwork()
        emit(Result.Success(user))
    } catch (e: Exception) {
        emit(Result.Error(e))
    }
}
Здесь функция `fetchUserData` возвращает `Flow`, который асинхронно генерирует различные результаты (например, загрузку данных, успешный результат или ошибку).
В целом, `Flow` предоставляет элегантный и эффективный способ работы с асинхронными операциями в Kotlin.
 */