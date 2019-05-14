package com.example.neteasecloudmusic.network.music

import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.MainService

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

    fun getComment(id: Int?, limit: Int?, timestamp: Long?, back: (Status, MusicCommentDataBean?) -> (Unit)) {
        val call = MainService.getMusicComment(id, limit, timestamp)
        object : Thread() {
            override fun run() {
                try {
                    val musicCommentDataBean = call.execute().body()
                    if (musicCommentDataBean == null) back(Status.INV, null)
                    else back(Status.OK, musicCommentDataBean)
                } catch (e: Exception) {
                    back(Status.INV, null)
                }
            }
        }.start()
    }

    fun likeComment(id: Int?, cid: Int?, t: Int?, type: Int?, timestamp: Long?, back: (Status) -> (Unit)) {
        object : Thread() {
            override fun run() {
                try {
                    MainService.likeComment(id, cid, t, type, timestamp).execute()
                    back(Status.OK)
                } catch (e: Exception) {
                    back(Status.INV)
                }
            }
        }.start()
    }

    fun comment(t: Int?, type: Int?, id: Int?, content: String?, back: (Status) -> (Unit)) {
        object : Thread() {
            override fun run() {
                try {
                    MainService.comment(t, type, id, content).execute()
                    back(Status.OK)
                } catch (e: Exception) {
                    back(Status.INV)
                }
            }
        }.start()
    }

    fun search(keyword: String?, back: (Status, SearchDataBean?) -> (Unit)) {
        val call = MainService.getSearchData(keyword, 30, 1)
        object : Thread() {
            override fun run() {
                try {
                    val searchDataBean = call.execute().body()
                    if (searchDataBean == null) back(Status.NETERR, null)
                    else back(Status.OK, searchDataBean)
                } catch (e: Exception) {
                    back(Status.NETERR, null)
                }
            }
        }.start()
    }
}