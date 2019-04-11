package com.example.neteasecloudmusic.view.music

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.neteasecloudmusic.MusicPlayActivity
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.DialogCenter
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.ItemController
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.network.music.MusicFactory
import org.jetbrains.anko.runOnUiThread
import org.w3c.dom.Text

class MusicItem(var c: Context, var id: Int, var title: String?, var info: String?, var rk: Int?) :
    Item {
    var isOK: Boolean = false
    var msg: String = "BUG!!"

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as MusicItem.ViewHolder
            item as MusicItem
            holder.rank.text = item.rk.toString()
            holder.info.text = item.info
            holder.title.text = if (item.title?.length!! < 25) item.title else item.title?.substring(0, 25) + "..."
            MusicFactory.getMusicCheck(item.id) { b ->
                item.c.runOnUiThread {
                    if (!b) item.msg = "NetWork Error or No CopyRight."
                    else item.isOK = true
                    if (!item.isOK) holder.title.setTextColor(item.c.resources.getColor(R.color.dark_white))
                    else holder.title.setTextColor(item.c.resources.getColor(R.color.white))
                }
            }
            holder.constraint.setOnClickListener {
                if (item.isOK) {
                    val intent = Intent(item.c, MusicPlayActivity::class.java)
                    intent.putExtra("id", item.id)
                    item.c.startActivity(intent)
                } else DialogCenter.getAlertDialog(item.c, "Something Wrong!!", item.msg) { _, _ -> }.show()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.music_info_layout, parent, false))
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rank = view.findViewById<TextView>(R.id.rank)
        val title = view.findViewById<TextView>(R.id.title)
        val info = view.findViewById<TextView>(R.id.info)
        val constraint = view.findViewById<ConstraintLayout>(R.id.constraint)

    }

    override val controller: ItemController
        get() = Controller
}