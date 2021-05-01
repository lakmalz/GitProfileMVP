package com.lakmalz.gitprofilemvp.util

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(AUTHORIZATION, BEARER_TOKEN)
            .build()

        return chain.proceed(request)
    }
}