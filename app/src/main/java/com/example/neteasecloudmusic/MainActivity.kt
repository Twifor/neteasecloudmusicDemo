package com.example.neteasecloudmusic

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.neteasecloudmusic.common.DialogCenter
import com.example.neteasecloudmusic.network.login.LoginFactory
import kotlinx.android.synthetic.main.layout_main_title.*
import org.jetbrains.anko.dip
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private var share: SharedPreferences? = null
    private fun makePopupWindow() {//弹出菜单
        val view = LayoutInflater.from(this).inflate(R.layout.popupwindow_layout, null, false)
        val popupWindow = PopupWindow(this)
        popupWindow.contentView = view
        popupWindow.width = dip(280)
        popupWindow.isFocusable = true
        popupWindow.animationStyle = R.style.style_pop_animation
        popupWindow.setBackgroundDrawable(null)
        popupWindow.height = WindowManager.LayoutParams.MATCH_PARENT
        Glide.with(this)
            .load(share?.getString("background_url", "233"))
            .into(popupWindow.contentView.findViewById(R.id.backGround))
        Glide.with(this)
            .load(share?.getString("avatar_url", "233"))
            .asBitmap()
            .into(popupWindow.contentView.findViewById(R.id.avatar))
        popupWindow.contentView.findViewById<TextView>(R.id.user_name).text = share?.getString("nickname", "ERR")
        popupWindow.contentView.findViewById<LinearLayout>(R.id.logout).setOnClickListener {
            DialogCenter.getAlertDialog(this, "Logout Confirm", "Are you sure to logout?") { _, _ ->
                LoginFactory.logout()
                share?.edit()?.clear()?.apply()
                startActivity<LoginActivity>()
                finish()
            }.show()
        }
        popupWindow.contentView.findViewById<ImageView>(R.id.backGround).setOnClickListener {
            popupWindow.dismiss()
            startActivity<UserDetailActivity>()
        }
        when (share?.getInt("gender", 0)) {
            1 -> popupWindow.contentView.findViewById<ImageView>(R.id.gender).setImageResource(R.drawable.boy)
            2 -> popupWindow.contentView.findViewById<ImageView>(R.id.gender).setImageResource(R.drawable.girl)
        }
        popupWindow.showAtLocation(
            LayoutInflater.from(this).inflate(R.layout.mainactivity, null),
            Gravity.LEFT,
            0,
            500
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.mainactivity)
        share = getSharedPreferences("data", Context.MODE_PRIVATE)
        menu_btn.setOnClickListener {
            makePopupWindow()
        }
    }
}