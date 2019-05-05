package com.example.neteasecloudmusic

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.neteasecloudmusic.common.SharedCenter
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.login.LoginFactory
import kotlinx.android.synthetic.main.layout_title.*
import kotlinx.android.synthetic.main.loginmain.*
import org.jetbrains.anko.startActivity

class LoginMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.loginmain)
        bk_btn.setOnClickListener {
            finish()
        }
        login_btn_main.setOnClickListener {
            if (phoneNumEDT.text.toString() == "") {
                Toast.makeText(this, "Require phone number", Toast.LENGTH_SHORT).show()
            } else {
                LoginFactory.login(phoneNumEDT.text.toString(), pwdEDT.text.toString()) { status, data ->
                    runOnUiThread {
                        when (status) {
                            Status.OK -> {
                                Toast.makeText(this, "Welcome!${data!!.profile?.nickname}", Toast.LENGTH_SHORT).show()
                                SharedCenter.updateUserInfo(
                                    data,
                                    phoneNumEDT.text.toString(),
                                    pwdEDT.text.toString()
                                )
                                startActivity<MainActivity>()
                                finish()
                            }
                            Status.INV -> Toast.makeText(
                                this,
                                "Wrong password or invalid user",
                                Toast.LENGTH_SHORT
                            ).show()
                            Status.NETERR->Toast.makeText(
                                this,
                                "Network Error",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }
}