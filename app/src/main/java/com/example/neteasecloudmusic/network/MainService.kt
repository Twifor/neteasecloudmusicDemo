package com.example.neteasecloudmusic.network

import com.example.neteasecloudmusic.network.login.LoginDataBean
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainService {
    @GET("/login/cellphone?")
    fun getLoginStatus(@Query("phone") phoneNum: String, @Query("password") pwd: String): Call<LoginDataBean>

    @GET("/logout")
    fun logout(): Call<ResponseBody>

    companion object : MainService by ServiceFactory()
}