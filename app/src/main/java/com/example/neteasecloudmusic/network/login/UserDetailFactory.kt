package com.example.neteasecloudmusic.network.login

import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.MainService
import java.lang.Exception

object UserDetailFactory {
    fun getUserDetail(id: Int?, back: (Status, UserDetailBean?) -> (Unit)) {
        val call = MainService.getUserDetail(id)
        object : Thread() {
            override fun run() {
                try {
                    val userDetailBean = call.execute().body()
                    if (userDetailBean == null) back(Status.UNK, userDetailBean)
                    else back(Status.OK, userDetailBean)
                } catch (e: Exception) {
                    back(Status.UNK, null)
                }
            }
        }.start()
    }
}