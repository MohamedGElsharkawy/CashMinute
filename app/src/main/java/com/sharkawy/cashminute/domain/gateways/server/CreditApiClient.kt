package com.sharkawy.cashminute.domain.gateways.server

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitClient: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(SERVER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpclient)
        .build()
}

val okHttpclient = OkHttpClient().newBuilder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        HttpLoggingInterceptor.Level.BODY
    }).build()

