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

    fun getMixDetail(id: Int, back: (Status, MixDetailBean?) -> (Unit)) {
        val call = MainService.getMixDetail(id)
        object : Thread() {
            override fun run() {
                try {
                    val mixDetailBean = call.execute().body()
                    if (mixDetailBean == null) back(Status.UNK, mixDetailBean)
                    else back(Status.OK, mixDetailBean)
                } catch (e: Exception) {
                    e.printStackTrace()
                    back(Status.INV, null)
                }
            }
        }.start()
    }
}