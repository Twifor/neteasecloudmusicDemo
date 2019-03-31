package com.example.neteasecloudmusic

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.neteasecloudmusic.network.login.LoginFactory
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.loginmain.*
import org.jetbrains.anko.startActivity


class LoginActivity : AppCompatActivity() {
    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        supportActionBar?.hide()
        setContentView(R.layout.login)
        login_btn.setOnClickListener {
            startActivity<LoginMainActivity>()
        }
    }
}