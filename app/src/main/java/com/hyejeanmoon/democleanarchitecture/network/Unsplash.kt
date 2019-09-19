package com.hyejeanmoon.democleanarchitecture.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * retrofitとokhttpClientの初期化クラス
 */
class Unsplash {

    private val client: OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(HeaderInterceptor("fa60305aa82e74134cabc7093ef54c8e2c370c47e73152f72371c828daedfcd7"))
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl("https://api.unsplash.com/")
            .client(client)
            .build()
    }


}