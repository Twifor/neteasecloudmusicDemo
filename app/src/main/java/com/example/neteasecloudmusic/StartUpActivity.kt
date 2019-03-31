package com.example.neteasecloudmusic

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.example.neteasecloudmusic.common.SharedCenter
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.login.LoginFactory
import org.jetbrains.anko.startActivity

class StartUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        setContentView(R.layout.startup)
        object : Thread() {
            override fun run() {
                Thread.sleep(1000)
                val share = getSharedPreferences("data", Context.MODE_PRIVATE)
                val phone = share.getString("phoneNum", null)
                val pwd = share.getString("pwd", null)
                if (phone == null) startActivity<LoginActivity>()
                else LoginFactory.login(phone, pwd) { status, data ->
                    if (status != Status.OK) {
                        runOnUiThread{
                            Toast.makeText(this@StartUpActivity, "Error,please login again.", Toast.LENGTH_SHORT).show()
                        }
                        startActivity<LoginActivity>()
                    } else {
                        SharedCenter.updateUserInfo(share, data!!, phone, pwd)
                        startActivity<MainActivity>()
                    }
                }
                Thread.sleep(2000)
                finish()
            }
        }.start()
    }
}
