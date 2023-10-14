package com.example.camera_monitoring.data.retrofit

import com.example.camera_monitoring.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val retrofit: Retrofit = Retrofit.Builder().baseUrl("http://cars.cprogroup.ru/api/rubetek/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}