package com.cobosoft.horoscapp.Data.Providers.Core.Interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
            .newBuilder().header("Autorization", "HOLITAAAA" ).build()

        return chain.proceed(request)

    }
}