package com.example.neteasecloudmusic.network

import com.example.neteasecloudmusic.common.SharedCenter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ServiceFactory {
    private const val BASE_URL = "http://192.168.43.15:3000"//192.168.43.15:3000//10.0.2.2:3000
    private val client = OkHttpClient
        .Builder()
        .addInterceptor {
            val resp = it.proceed(it.request())
            val cookies = resp.headers("Set-Cookie")
            var cookieStr = ""
            if (cookies != null && cookies.size > 0) {
                for (i in cookies) cookieStr += i
                SharedCenter.saveCookieID(cookieStr)
            }
            resp
        }
        .addInterceptor {
            val cookieStr = SharedCenter.getCookieID()
            if (cookieStr != null) it.proceed(it.request().newBuilder().header("Cookie", cookieStr).build())
            else it.proceed(it.request())
        }
        .connectTimeout(2, TimeUnit.SECONDS)
        .build()
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    inline operator fun <reified T> invoke(): T = retrofit.create(T::class.java)
}