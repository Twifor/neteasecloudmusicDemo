package com.example.neteasecloudmusic.common

import android.media.MediaPlayer

object MusicCenter {
    //相当于单例，保证同一时间只有一首音乐在播放
    val musicPlayer = MediaPlayer()
    val isPlaying
        get() = musicPlayer.isPlaying
    var id: Int = 0
    fun play(url: String?, pid: Int) {
        musicPlayer.stop()
        id = pid
        musicPlayer.reset()//重置播放器
        musicPlayer.setDataSource(url)
        musicPlayer.prepare()
        musicPlayer.start()
    }

    fun pause() {
        if (isPlaying) musicPlayer.pause()
    }

    fun stop() {
        if (isPlaying) musicPlayer.stop()
    }

    fun endPause() {
        if (!isPlaying) musicPlayer.start()
    }
}