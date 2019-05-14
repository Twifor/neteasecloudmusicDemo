package com.example.neteasecloudmusic.common

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.provider.MediaStore

class MusicService : Service() {
    val mediaPlayer = MediaPlayer()
    var id: Int? = 0
    override fun onBind(intent: Intent?): IBinder? {
        return MyBinder()
    }

    inner class MyBinder : Binder() {
        fun isPlaying(): Boolean {
            return mediaPlayer.isPlaying
        }

        fun getID() = id
        fun start(url: String?, id: Int?) {
            this@MusicService.id = id
            mediaPlayer.setDataSource(url)
            mediaPlayer.prepare()
            mediaPlayer.start()
        }

        fun play() {
            if (!mediaPlayer.isPlaying) mediaPlayer.start()
        }

        fun pause() {
            if (mediaPlayer.isPlaying) mediaPlayer.pause()
        }

        fun getPos(): Int {
            return mediaPlayer.currentPosition
        }

        fun seekToPos(pos: Int) {
            mediaPlayer.seekTo(pos)
        }

        fun getDuration(): Int {
            return mediaPlayer.duration
        }
    }
}