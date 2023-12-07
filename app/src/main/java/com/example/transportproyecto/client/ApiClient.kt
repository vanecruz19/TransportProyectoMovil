package com.example.transportproyecto.client

import com.example.transportproyecto.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {



    const val baseUrl = "http://192.168.206.158:8000" /// Reemplaza esto con tu baseUrl



    private fun getRetrofit(): Retrofit {

        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient().newBuilder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(baseUrl)
            .build()
    }

    fun getApiService(): ApiService{
        return getRetrofit().create(ApiService::class.java)
    }

}