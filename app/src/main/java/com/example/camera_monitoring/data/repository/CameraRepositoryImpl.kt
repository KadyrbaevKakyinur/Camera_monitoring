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

     override suspend fun getResult(): Flow<List<CameraModel>> {
        return flow {
            val data = RetrofitService.apiService.getCameras().body()?.data?.cameras
            if (data != null) {
                emit(data)
            }
        }
    }

    override suspend fun insertCamera(camera: CameraModel) {
        cameraDao.insertCamera(camera.convertToCamera())
    }

    override suspend fun updateCamera(camera: CameraModel) {
        cameraDao.updateCamera(camera.convertToCamera())
    }

    override suspend fun deleteCamera(camera: CameraModel) {
        cameraDao.deleteCamera(camera.convertToCamera())
    }
}