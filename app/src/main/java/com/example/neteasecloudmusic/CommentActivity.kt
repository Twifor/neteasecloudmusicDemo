package com.example.neteasecloudmusic

import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.common.withItems
import com.example.neteasecloudmusic.network.music.MusicFactory
import com.example.neteasecloudmusic.view.music.CommentItem
import kotlinx.android.synthetic.main.comment_main_layout.*


class CommentActivity : AppCompatActivity() {
    private var id: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        supportActionBar?.hide()
        setContentView(R.layout.comment_main_layout)
        back_btn.setOnClickListener {
            finish()
        }
        id = intent.getIntExtra("id", 0)
        MusicFactory.getComment(id, 20) { status, musicCommentDataBean ->
            when (status) {
                Status.INV -> Toast.makeText(this, "Internet Error", Toast.LENGTH_SHORT).show()
                Status.OK -> {
                    runOnUiThread {
                        val list = mutableListOf<Item>()
                        for (l in musicCommentDataBean?.hotComments!!) {
                            list.add(
                                CommentItem(
                                    this@CommentActivity,
                                    l.user?.avatarUrl,
                                    l.time,
                                    l.content,
                                    l.user?.nickname
                                )
                            )
                        }
                        recyclerView.layoutManager = LinearLayoutManager(this@CommentActivity)
                        recyclerView.withItems(list)
                    }
                }
            }
        }
    }
}