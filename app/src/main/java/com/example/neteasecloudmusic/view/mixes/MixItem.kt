package com.example.neteasecloudmusic.view.mixes

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.ItemController

class MixItem(var c: Context?, var coverURL: String?, var t: String?, var i: String?, var id: Int) : Item {
    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as MixItem.ViewHolder
            item as MixItem
            holder.title.text = item.t
            holder.info.text = item.i
            Glide.with(item.c).load(item.coverURL).into(holder.cover)

        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.mix_layout, parent, false))
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cover = view.findViewById<ImageView>(R.id.cover)
        val title = view.findViewById<TextView>(R.id.title)
        val info = view.findViewById<TextView>(R.id.info)
    }

    override val controller: ItemController
        get() = Controller
}