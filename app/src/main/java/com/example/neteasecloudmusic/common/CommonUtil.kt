package com.example.neteasecloudmusic.common

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.util.concurrent.CopyOnWriteArrayList

class CommonUtil : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

}