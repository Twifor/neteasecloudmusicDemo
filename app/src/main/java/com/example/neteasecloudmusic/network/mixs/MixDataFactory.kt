package com.example.neteasecloudmusic.network.mixs

import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.MainService
import java.lang.Exception

object MixDataFactory {
    fun getMixesData(id: Int, back: (Status, MixDataBean?) -> (Unit)) {
        val call = MainService.getMixesData(id)
        object : Thread() {
            override fun run() {
                try {
                    val mixDataBean = call.execute().body()
                    if (mixDataBean == null) back(Status.UNK, mixDataBean)
                    else back(Status.OK, mixDataBean)
                } catch (e: Exception) {
                    back(Status.UNK, null)
                }
            }
        }.start()
    }
}