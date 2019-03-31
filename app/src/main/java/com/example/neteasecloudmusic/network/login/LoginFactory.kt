package com.example.neteasecloudmusic.network.login

import android.os.AsyncTask
import com.example.neteasecloudmusic.common.SharedCenter
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.MainService
import java.lang.Exception
import java.net.SocketTimeoutException

object LoginFactory {
    fun login(phone: String, pwd: String, back: (Status, LoginDataBean?) -> (Unit)) {
        val call = MainService.getLoginStatus(phone, pwd)
        object : Thread() {
            override fun run() {
                try {
                    val loginDataBean = call.execute().body()
                    if (loginDataBean == null) back(Status.INV, null)
                    else back(Status.OK, loginDataBean)
                } catch (e: Exception) {
                    back(Status.NETERR, null)
                }
            }
        }.start()
    }

    fun logout() {
        val call = MainService.logout()
        object : Thread() {
            override fun run() {
                call.execute().body()
            }
        }.start()
    }

}