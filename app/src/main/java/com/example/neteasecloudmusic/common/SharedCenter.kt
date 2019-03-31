package com.example.neteasecloudmusic.common

import android.content.SharedPreferences
import com.example.neteasecloudmusic.network.login.LoginDataBean
import kotlinx.android.synthetic.main.loginmain.*

object SharedCenter {
    fun updateUserInfo(s: SharedPreferences, i: LoginDataBean, ph: String, pwd: String) {
        s.edit()
            .putString("avatar_url", i.profile?.avatarUrl)
            .putString("nickname", i.profile?.nickname)
            .putInt("gender", i.profile?.gender ?: 0)
            .putString("phoneNum", ph)
            .putString("pwd", pwd)
            .putInt("id", i.account?.id ?: 0)
            .putString("background_url", i.profile?.backgroundUrl).apply()
    }
}