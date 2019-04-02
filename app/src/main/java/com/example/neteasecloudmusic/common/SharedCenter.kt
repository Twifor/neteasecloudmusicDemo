package com.example.neteasecloudmusic.common

import android.content.SharedPreferences
import com.example.neteasecloudmusic.network.login.LoginDataBean
import com.example.neteasecloudmusic.network.login.UserDetailBean
import kotlinx.android.synthetic.main.loginmain.*

object SharedCenter {
    fun updateUserInfo(s: SharedPreferences, i: LoginDataBean, ph: String, pwd: String) {
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

    fun updateUserDetail(s: SharedPreferences, d: UserDetailBean?) {
        s.edit()
            .putInt("level", d?.level ?: 0)
            .apply()
    }
}