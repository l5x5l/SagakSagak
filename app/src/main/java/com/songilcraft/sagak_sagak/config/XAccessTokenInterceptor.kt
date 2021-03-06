package com.songilcraft.sagak_sagak.config

import com.songilcraft.sagak_sagak.config.GlobalApplication.Companion.X_ACCESS_TOKEN
import com.songilcraft.sagak_sagak.config.GlobalApplication.Companion.globalSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class XAccessTokenInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder : Request.Builder = chain.request().newBuilder()
        val jwtToken : String? = globalSharedPreferences.getString(X_ACCESS_TOKEN, null)
        if (jwtToken != null) {
            builder.addHeader("X-ACCESS-TOKEN", jwtToken)
        }
        return chain.proceed(builder.build())
    }
}