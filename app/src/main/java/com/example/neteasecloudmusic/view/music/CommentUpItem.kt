package com.example.neteasecloudmusic.view.music

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.ItemController
import kotlinx.android.synthetic.main.comment_layout.view.*
import java.util.zip.Inflater


class CommentUpItem(var con: String?) : Item {
    override val controller: ItemController
        get() = Controller

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as CommentUpItem.ViewHolder
            item as CommentUpItem
            holder.content.text = item.con
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return CommentUpItem.ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.comment_up_layout,
                    parent,
                    false
                )
            )
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val content = view.findViewById<TextView>(R.id.content)
    }
}