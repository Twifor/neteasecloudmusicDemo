package com.example.neteasecloudmusic.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.ItemController
import kotlinx.android.synthetic.main.user_detail_layout.view.*

class UserItem(var c: Context, var avatar: String?, var bg: String?, var name: String?) : Item {
    companion object Controller : ItemController {
        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return UserItem.ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.user_detail_layout,
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as UserItem.ViewHolder
            item as UserItem
            holder.name.text = item.name
            Glide.with(item.c).load(item.bg).into(holder.backGround)
            Glide.with(item.c).load(item.avatar).asBitmap().into(holder.avatar)
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.name
        val backGround = view.findViewById<ImageView>(R.id.backGround)
        val avatar = view.avatar
    }

    override val controller: ItemController
        get() = Controller
}

fun MutableList<Item>.userItem(c: Context, avatar: String?, bg: String?, name: String?) =
    add(UserItem(c, avatar, bg, name))