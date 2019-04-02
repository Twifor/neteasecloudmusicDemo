package com.example.neteasecloudmusic.view.mixes

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neteasecloudmusic.R
import kotlinx.android.synthetic.main.user_data_main_layout.*

class UserDataFragment : Fragment() {
    var share: SharedPreferences? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.user_data_main_layout, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        share = context?.getSharedPreferences("data", Context.MODE_PRIVATE)
        level.text = "Level: ${share?.getInt("level", 0)}"
        gender.text = "Gender: ${
        when {
            share?.getInt("gender", 0) == 0 -> "Unknown"
            share?.getInt("gender", 0) == 1 -> "Male"
            else -> "Female"
        }
        }"
        region.text = "Region: ${share?.getInt("city", 0)}"
        profile.text = "${share?.getString("signature", "ERR")}"
    }
}