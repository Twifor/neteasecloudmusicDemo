package com.example.neteasecloudmusic.view.music

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.CircleImageView
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.ItemController

class CommentItem(var c: Context, var url: String?, var t: Long?, var con: String?, var user: String?) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as CommentItem.ViewHolder
            item as CommentItem
            Glide.with(item.c).load(item.url).asBitmap().into(holder.avatar)//头像
            holder.content.text = item.con
            holder.userName.text = item.user
            holder.time.text = item.t.toString()
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
    }
}