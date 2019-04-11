package com.example.neteasecloudmusic

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.play_main_layout.*

class MusicPlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        supportActionBar?.hide()
        setContentView(R.layout.play_main_layout)
        back_btn.setOnClickListener {
            finish()
        }
        val intent = Intent()
        intent.getIntExtra("id", 0)
    }
}