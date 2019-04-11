package com.example.neteasecloudmusic.common

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

object DialogCenter {
    fun getAlertDialog(c: Context, title: String, message: String?, f: (DialogInterface, Int) -> (Unit)): AlertDialog {
        val builder = AlertDialog.Builder(c)
        builder.setTitle(title).setMessage(message).setPositiveButton("OK", f).setNegativeButton("NO") { _, _ -> }
        return builder.create()
    }
}