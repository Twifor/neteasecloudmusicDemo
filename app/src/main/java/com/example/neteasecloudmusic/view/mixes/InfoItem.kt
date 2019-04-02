package com.example.neteasecloudmusic.view.mixes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.ItemController

class InfoItem(var s: String) : Item {
    companion object Controller : ItemController {


        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.info_item_layout, parent, false))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as InfoItem.ViewHolder
            item as InfoItem
            holder.info.text = item.s
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val info = view.findViewById<TextView>(R.id.info)
    }

    override val controller: ItemController
        get() = Controller
}

fun MutableList<Item>.infoItem(s: String) = add(InfoItem(s))