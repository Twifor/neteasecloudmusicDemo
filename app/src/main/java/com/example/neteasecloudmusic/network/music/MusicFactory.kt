package com.example.neteasecloudmusic.network.music

import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.MainService
import java.lang.Exception

object MusicFactory {
    fun getMusicCheck(id: Int, back: (Boolean) -> (Unit)) {
        val call = MainService.getMusicCheckData(id)
        object : Thread() {
            override fun run() {
                try {
                    val musicCheckDataBean = call.execute().body()
                    if (musicCheckDataBean == null) back(false)
                    else back(musicCheckDataBean.success)
                } catch (e: Exception) {
                    back(false)
                }
            }
        }.start()
    }
}