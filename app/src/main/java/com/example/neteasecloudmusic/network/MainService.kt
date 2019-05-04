package com.example.neteasecloudmusic.network

import com.example.neteasecloudmusic.network.login.LoginDataBean
import com.example.neteasecloudmusic.network.login.UserDetailBean
import com.example.neteasecloudmusic.network.mixs.MixDataBean
import com.example.neteasecloudmusic.network.mixs.MixDetailBean
import com.example.neteasecloudmusic.network.music.MusicCheckDataBean
import com.example.neteasecloudmusic.network.music.MusicCommentDataBean
import com.example.neteasecloudmusic.network.music.MusicDetailBean
import com.example.neteasecloudmusic.network.music.MusicUrlBean
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainService {
    //统一管理所有网络接口
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

    @GET("/song/detail?")
    fun getMusicDetail(@Query("ids") ids: Int?): Call<MusicDetailBean>

    @GET("/song/url?")
    fun getMusicUrl(@Query("id") id: Int?): Call<MusicUrlBean>

    @GET("/comment/music?")
    fun getMusicComment(@Query("id") id: Int?, @Query("limit") limit: Int?): Call<MusicCommentDataBean>

    companion object : MainService by ServiceFactory()
}