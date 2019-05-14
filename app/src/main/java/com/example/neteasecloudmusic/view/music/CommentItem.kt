package com.example.neteasecloudmusic.view.music

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.provider.ContactsContract
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.*
import com.example.neteasecloudmusic.network.music.MusicCommentDataBean
import com.example.neteasecloudmusic.network.music.MusicFactory
import org.jetbrains.anko.runOnUiThread
import java.sql.Date
import java.text.SimpleDateFormat

class CommentItem(
    var c: Context,
    var id: Int?,
    var cid: Int?,
    var url: String?,
    var t: Long?,
    var con: String?,
    var user: String?,
    var numOfLike: Int?,
    var isLiked: Boolean,
    var beReplied: List<MusicCommentDataBean.HotCommentsBean.BeRepliedBean>?
) : Item {

    companion object Controller : ItemController {
        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as CommentItem.ViewHolder
            item as CommentItem
            Glide.with(item.c).load(item.url).asBitmap().into(holder.avatar)//头像
            holder.content.text = item.con
            holder.userName.text = item.user
            holder.time.text = SimpleDateFormat("yyyy年MM月dd日").format(item.t)
            try {
                holder.replayText.visibility = View.VISIBLE
                holder.replayText.text = "@${item.beReplied?.get(0)?.user?.nickname}:${item.beReplied?.get(0)?.content}"
            } catch (e: Exception) {
                holder.replayText.visibility = View.GONE
            }
            if (item.isLiked) {
                holder.likeBtn.background = item.c.resources.getDrawable(R.drawable.a5y)
                holder.likeNum.setTextColor(Color.RED)
            } else {
                holder.likeBtn.background = item.c.resources.getDrawable(R.drawable.a5x)
                holder.likeNum.setTextColor(Color.WHITE)
            }
            holder.likeNum.text = item.numOfLike.toString()
            holder.likeBtn.setOnClickListener {
                if (!item.isLiked) {
                    MusicFactory.likeComment(item.id, item.cid, 1, 0, System.currentTimeMillis() / 1000) { status ->
                        item.c.runOnUiThread {
                            when (status) {
                                Status.INV -> Toast.makeText(item.c, "Internet Error", Toast.LENGTH_SHORT).show()
                                Status.OK -> {
                                    holder.likeBtn.background = item.c.resources.getDrawable(R.drawable.a5y)
                                    holder.likeNum.setTextColor(Color.RED)
                                    holder.likeNum.text = item.numOfLike?.plus(1).toString()
                                    item.numOfLike = item.numOfLike?.plus(1)
                                    item.isLiked = true
                                }
                            }
                        }
                    }
                } else {
                    MusicFactory.likeComment(item.id, item.cid, 0, 0, System.currentTimeMillis() / 1000) { status ->
                        item.c.runOnUiThread {
                            when (status) {
                                Status.INV -> Toast.makeText(item.c, "Internet Error", Toast.LENGTH_SHORT).show()
                                Status.OK -> {
                                    holder.likeBtn.background = item.c.resources.getDrawable(R.drawable.a5x)
                                    holder.likeNum.setTextColor(Color.WHITE)
                                    holder.likeNum.text = item.numOfLike?.minus(1).toString()
                                    item.numOfLike = item.numOfLike?.minus(1)
                                    item.isLiked = false
                                }
                            }
                        }
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return CommentItem.ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.comment_layout,
                    parent,
                    false
                )
            )
        }
    }

    override val controller: ItemController
        get() = Controller

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar = view.findViewById<CircleImageView>(R.id.avatar)
        val userName = view.findViewById<TextView>(R.id.userName)
        val time = view.findViewById<TextView>(R.id.time)
        val content = view.findViewById<TextView>(R.id.content)
        val likeNum = view.findViewById<TextView>(R.id.likeNum)
        val likeBtn = view.findViewById<ImageButton>(R.id.likeBtn)
        val replayText = view.findViewById<TextView>(R.id.replyText)
    }
}