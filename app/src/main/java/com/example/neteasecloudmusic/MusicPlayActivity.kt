package com.example.neteasecloudmusic

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.neteasecloudmusic.common.MusicCenter
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.music.MusicFactory
import kotlinx.android.synthetic.main.play_main_layout.*
import org.jetbrains.anko.startActivity

class MusicPlayActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {//通过进度条来控制播放进度
        if (fromUser) mediaPlay.seekTo((progress.toDouble() / 100f * mediaPlay.duration).toInt())
    }

    private val mediaPlay = MusicCenter.musicPlayer
    private var handler: Handler? = null
    private var flag: Boolean = false//控制线程退出
    @SuppressLint("SetTextI18n")
    private val runnable = Runnable {
        while (true) {//反复更新
            seek.progress = (mediaPlay.currentPosition * 100f / mediaPlay.duration).toInt()
            if (flag) break
            runOnUiThread {
                currentTime.text =
                    "${mediaPlay.currentPosition / 1000 / 60}:${mediaPlay.currentPosition / 1000 % 60 / 10}${mediaPlay.currentPosition / 1000 % 60 % 10}"
                totTime.text =
                    "${mediaPlay.duration / 1000 / 60}:${mediaPlay.duration / 1000 % 60 / 10}${mediaPlay.duration / 1000 % 60 % 10}"
            }
            Thread.sleep(100)
        }
    }

    private fun init() {//用于控制播放时间并关联进度条和mediaPlayer
        val handlerThread = HandlerThread("MainMusicThread")
        handlerThread.start()
        handler = Handler(handlerThread.looper)
        handler!!.post(runnable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        supportActionBar?.hide()
        setContentView(R.layout.play_main_layout)
        back_btn.setOnClickListener {
            finish()
        }
        val id = intent.getIntExtra("id", 0)
        MusicFactory.getMusicDetail(id) { status, musicDetailBean ->
            runOnUiThread {
                when (status) {
                    is Status.INV -> Toast.makeText(this, "Internet Error", Toast.LENGTH_SHORT).show()
                    is Status.UNK -> Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show()
                    else -> {
                        Glide.with(this).load(musicDetailBean?.songs?.get(0)?.al?.picUrl).asBitmap().into(rotateView)
                    }
                }
            }
        }
        MusicFactory.getUrl(id) { status, musicUrlBean ->
            runOnUiThread {
                when (status) {
                    is Status.INV -> {
                        Toast.makeText(this, "Internet Error", Toast.LENGTH_SHORT).show()
                        rotateView.pause()
                    }
                    is Status.UNK -> {
                        Toast.makeText(this, "Unknown Error", Toast.LENGTH_SHORT).show()
                        rotateView.pause()
                    }
                    else -> {
                        if (MusicCenter.id != musicUrlBean?.data?.get(0)?.id!!) {
                            MusicCenter.play(
                                musicUrlBean.data?.get(0)?.url,
                                musicUrlBean.data?.get(0)?.id!!
                            )
                            rotateView.play()
                        } else {//上一次的正在播放，直接拿来用就可以了
                            if (!MusicCenter.isPlaying) {//改一改UI
                                play.background =
                                    this@MusicPlayActivity.resources.getDrawable(R.drawable.agr)
                            } else rotateView.play()
                        }
                        init()
                    }
                }
            }
        }
        play.setOnClickListener {
            //播放暂停按钮点击监听
            if (MusicCenter.isPlaying) {
                MusicCenter.pause()
                play.background = this.resources.getDrawable(R.drawable.agr)//换一下图标
                rotateView.pause()
            } else {
                MusicCenter.endPause()
                play.background = this.resources.getDrawable(R.drawable.agq)
                rotateView.play()
            }
        }
        comment_btn.setOnClickListener {
            val intent = Intent(this, CommentActivity::class.java)
            intent.putExtra("id", id)
            this.startActivity(intent)
        }
        seek.setOnSeekBarChangeListener(this)
    }

    override fun onDestroy() {
        flag = true//修改flag指标
        if (handler != null) handler!!.removeCallbacks(runnable)//销毁线程
        super.onDestroy()
    }
}