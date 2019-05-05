package com.example.neteasecloudmusic.common

import android.content.Context
import android.content.SharedPreferences
import com.example.neteasecloudmusic.network.login.LoginDataBean
import com.example.neteasecloudmusic.network.login.UserDetailBean

object SharedCenter {
    private val s = CommonUtil.context.getSharedPreferences("data", Context.MODE_PRIVATE)
    fun updateUserInfo(i: LoginDataBean, ph: String?, pwd: String?) {
        s.edit()
            .putString("avatar_url", i.profile?.avatarUrl)
            .putString("nickname", i.profile?.nickname)
            .putInt("gender", i.profile?.gender ?: 0)
            .putString("phoneNum", ph)
            .putString("pwd", pwd)
            .putInt("city", i.profile?.city ?: 0)
            .putInt("id", i.account?.id ?: 0)
            .putString("signature", i.profile?.signature)
            .putString("background_url", i.profile?.backgroundUrl).apply()
    }

    fun getPhoneNUm(): String? {
        return s.getString("phoneNum", null)
    }

    fun getPassWord(): String? {
        return s.getString("pwd", null)
    }

    fun updateUserDetail(d: UserDetailBean?) {
        s.edit()
            .putInt("level", d?.level ?: 0)
            .apply()
    }

    fun saveCookieID(cookie: String?) {
        s.edit().putString("cookieID", cookie).apply()
    }

    fun getCookieID(): String? {
        return s.getString("cookieID", null)
    }
}