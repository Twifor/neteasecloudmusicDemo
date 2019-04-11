package com.example.neteasecloudmusic.view.mixes

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.common.withItems
import com.example.neteasecloudmusic.network.mixs.MixDataFactory
import kotlinx.android.synthetic.main.mixes_layout.view.*
import org.jetbrains.anko.runOnUiThread

class MixFragment : Fragment() {
    private var share: SharedPreferences? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.mixes_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val l = mutableListOf<Item>()
        share = context?.getSharedPreferences("data", Context.MODE_PRIVATE)
        view.recyclerView.layoutManager = LinearLayoutManager(this.context)
        MixDataFactory.getMixesData(share!!.getInt("id", 0)) { status, data ->
            context?.runOnUiThread {
                when (status) {
                    Status.UNK -> {
                        l.add(InfoItem("My Mixes"))
                        l.add(InfoItem("Fav Mixes"))
                        Toast.makeText(context, "Unknown ERR", Toast.LENGTH_SHORT).show()
                    }
                    Status.OK -> {
                        l.add(InfoItem("My Mixes"))
                        for (i in data?.playlist!!) {
                            if (i.creator?.userId == share?.getInt("id", 0)) {
                                l.add(
                                    MixItem(
                                        context,
                                        i.coverImgUrl,
                                        if (i.name?.length!! > 15) "${i.name?.substring(0, 15)}..." else i.name,
                                        i.trackCount.toString() + " songs,by " + i.creator?.nickname + "," +
                                                if (i.playCount < 10000) i.playCount.toString() else {
                                                    (i.playCount / 10000).toString() + "万"
                                                } + "plays",
                                        i.id
                                    )
                                )
                            }
                        }
                        l.add(InfoItem("Fav Mixes"))
                        for (i in data.playlist!!) {
                            if (i.creator?.userId != share?.getInt("id", 0)) {
                                l.add(
                                    MixItem(
                                        context,
                                        i.coverImgUrl,
                                        if (i.name?.length!! > 15) "${i.name?.substring(0, 15)}..." else i.name,
                                        "${i.trackCount} songs,by ${i.creator?.nickname},${if (i.playCount < 10000) i.playCount.toString() else (i.playCount / 1000).toString() + "万"}plays",
                                        i.id
                                    )
                                )
                            }
                        }
                    }
                }
                view.recyclerView.withItems(l)
            }
        }
    }
}