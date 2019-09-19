package com.hyejeanmoon.democleanarchitecture.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.jetbrains.annotations.NotNull

/**
 * ID認証為のokhttpのInterceptor
 */
class HeaderInterceptor(private val client_id: String) : Interceptor {


    @NotNull
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Client-ID $client_id")
            .build()
        return chain.proceed(request)
    }
}