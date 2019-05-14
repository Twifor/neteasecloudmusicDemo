package com.example.neteasecloudmusic

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.neteasecloudmusic.common.*
import com.example.neteasecloudmusic.network.music.MusicFactory
import com.example.neteasecloudmusic.view.music.CommentItem
import com.example.neteasecloudmusic.view.music.CommentUpItem
import kotlinx.android.synthetic.main.comment_main_layout.*


class CommentActivity : AppCompatActivity() {
    private var id: Int? = 0
    @SuppressLint("SetTextI18n")
    private val list = mutableListOf<Item>()

    @SuppressLint("SetTextI18n")
    private fun get() {
        MusicFactory.getComment(id, 20, System.currentTimeMillis() / 1000) { status, musicCommentDataBean ->
            runOnUiThread {
                when (status) {
                    Status.INV -> Toast.makeText(this, "Internet Error", Toast.LENGTH_SHORT).show()
                    Status.OK -> {
                        totNum.text = "Comment(${musicCommentDataBean?.total})"
                        list.clear()
                        list.add(CommentUpItem("Top Comments"))
                        for (l in musicCommentDataBean?.hotComments!!) {
                            list.add(
                                CommentItem(
                                    this@CommentActivity,
                                    id,
                                    l.commentId,
                                    l.user?.avatarUrl,
                                    l.time,
                                    l.content,
                                    l.user?.nickname,
                                    l.likedCount,
                                    l.liked,
                                    l.beReplied
                                )
                            )
                        }
                        list.add(CommentUpItem("Latest Comments"))
                        for (l in musicCommentDataBean.comments!!) {
                            list.add(
                                CommentItem(
                                    this@CommentActivity,
                                    id,
                                    l.commentId,
                                    l.user?.avatarUrl,
                                    l.time,
                                    l.content,
                                    l.user?.nickname,
                                    l.likedCount,
                                    l.liked,
                                    l.beReplied
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        supportActionBar?.hide()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        setContentView(R.layout.comment_main_layout)
        back_btn.setOnClickListener {
            finish()
        }
        id = intent.getIntExtra("id", 0)
        swipeRefresh.setColorSchemeColors(resources.getColor(R.color.blue))

        send.setOnClickListener {
            val str = edit.text.toString()
            if (str == "") Toast.makeText(this, "The comment can't be empty!", Toast.LENGTH_SHORT).show()
            else MusicFactory.comment(1, 0, id, str) {
                runOnUiThread {
                    when (it) {
                        Status.INV -> Toast.makeText(this, "Internet Error", Toast.LENGTH_SHORT).show()
                        else -> {
                            Toast.makeText(this, "Send Comment Successfully", Toast.LENGTH_SHORT).show()
                            edit.text.clear()
                            get()
                        }
                    }
                }
            }
        }
        swipeRefresh.setOnRefreshListener {
            get()
            swipeRefresh.isRefreshing = false
        }
        get()
    }
}