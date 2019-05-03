package com.example.neteasecloudmusic.network.music

import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.MainService
import kotlinx.coroutines.android.Main
import java.lang.Exception

object MusicFactory {
    fun getMusicCheck(id: Int, back: (Boolean) -> (Unit)) {
        val call = MainService.getMusicCheckData(id)
        object : Thread() {
            override fun run() = try {
                val musicCheckDataBean = call.execute().body()
                if (musicCheckDataBean == null) back(false)
                else back(musicCheckDataBean.success)
            } catch (e: Exception) {
                back(false)
            }
        }.start()
    }

    fun getMusicDetail(id: Int?, back: (Status, MusicDetailBean?) -> (Unit)) {
        val call = MainService.getMusicDetail(id)
        object : Thread() {
            override fun run() {
                try {
                    val musicDetailBean = call.execute().body()
                    if (musicDetailBean == null) back(Status.UNK, null)
                    else back(Status.OK, musicDetailBean)
                } catch (e: Exception) {
                    back(Status.INV, null)
                }
            }
        }.start()
    }

    fun getUrl(id: Int?, back: (Status, MusicUrlBean?) -> (Unit)) {
        val call = MainService.getMusicUrl(id)
        object : Thread() {
            override fun run() {
                try {
                    val music = call.execute().body()
                    if (music == null) back(Status.UNK, null)
                    else back(Status.OK, music)
                } catch (e: Exception) {
                    back(Status.INV, null)
                }
            }
        }.start()
    }
}