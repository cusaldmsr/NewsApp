package com.cusaldev.newsapp.data.remort

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptors : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("authentication", "Bearer API_KEY")
            .build()
        request.body()
        request.url()
        val response = chain.proceed(request)

        response.body()
        response.code()
        return response
    }
}