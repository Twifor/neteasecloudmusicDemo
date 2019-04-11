package com.example.neteasecloudmusic.network

import com.example.neteasecloudmusic.network.login.LoginDataBean
import com.example.neteasecloudmusic.network.login.UserDetailBean
import com.example.neteasecloudmusic.network.mixs.MixDataBean
import com.example.neteasecloudmusic.network.mixs.MixDetailBean
import com.example.neteasecloudmusic.network.music.MusicCheckDataBean
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

    @GET("/user/playlist?")
    fun getMixesData(@Query("uid") uid: Int?): Call<MixDataBean>

    @GET("/user/detail?")
    fun getUserDetail(@Query("uid") uid: Int?): Call<UserDetailBean>

    @GET("/playlist/detail?")
    fun getMixDetail(@Query("id") id: Int?): Call<MixDetailBean>

    @GET("/check/music?")
    fun getMusicCheckData(@Query("id") id: Int?): Call<MusicCheckDataBean>

    companion object : MainService by ServiceFactory()
}