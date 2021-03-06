package com.example.neteasecloudmusic

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
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
                val phone = SharedCenter.getPhoneNUm()
                val pwd = SharedCenter.getPassWord()
                if (phone == null) startActivity<LoginActivity>()
                else LoginFactory.login(phone, pwd) { status, data ->
                    if (status != Status.OK) {
                        runOnUiThread {
                            Toast.makeText(this@StartUpActivity, "Error,please login again.", Toast.LENGTH_SHORT).show()
                        }
                        startActivity<LoginActivity>()
                    } else {
                        SharedCenter.updateUserInfo(data!!, phone, pwd)
                        startActivity<MainActivity>()
                    }
                }
                Thread.sleep(2000)
                finish()
            }
        }.start()
    }
}
