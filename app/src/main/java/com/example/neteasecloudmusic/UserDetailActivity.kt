package com.example.neteasecloudmusic

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.neteasecloudmusic.common.withItems
import com.example.neteasecloudmusic.view.userItem
import kotlinx.android.synthetic.main.user_detail_main_layout.*

class UserDetailActivity : AppCompatActivity() {
    private var share: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.user_detail_main_layout)
        share = getSharedPreferences("data", Context.MODE_PRIVATE)
        back_btn.setOnClickListener {
            finish()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.withItems {
            userItem(
                this@UserDetailActivity,
                share?.getString("avatar_url", "233"),
                share?.getString("background_url", "233"),
                share?.getString("nickname", "ERR")
            )
        }
    }
}