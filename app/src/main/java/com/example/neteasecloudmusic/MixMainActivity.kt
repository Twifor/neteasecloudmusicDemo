package com.example.neteasecloudmusic

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.example.neteasecloudmusic.common.ImageFilter
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.common.withItems
import com.example.neteasecloudmusic.network.mixs.MixDataFactory
import com.example.neteasecloudmusic.network.music.MusicFactory
import com.example.neteasecloudmusic.view.music.MusicItem
import kotlinx.android.synthetic.main.mix_main_layout.*

class MixMainActivity : AppCompatActivity() {
    var id: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mix_main_layout)
        supportActionBar?.hide()
        id = intent.getIntExtra("id", 0)
        back_btn.setOnClickListener {
            finish()
        }
        MixDataFactory.getMixDetail(id) { status, data ->
            runOnUiThread {
                when (status) {
                    Status.UNK -> Toast.makeText(this, "Something Error", Toast.LENGTH_SHORT).show()
                    Status.OK -> {
                        Glide.with(this).load(data?.playlist?.coverImgUrl).asBitmap()
                            .into(object : SimpleTarget<Bitmap>() {
                                override fun onResourceReady(
                                    resource: Bitmap?,
                                    glideAnimation: GlideAnimation<in Bitmap>?
                                ) {
                                    if (resource == null) return
                                    cover.setImageBitmap(resource)
                                    big_cover.setImageBitmap(
                                        ImageFilter.rsBlur(
                                            this@MixMainActivity,
                                            ImageFilter.rsBlur(
                                                this@MixMainActivity,
                                                ImageFilter.rGB565toARGB888(resource),
                                                25f
                                            ),
                                            25f
                                        )
                                    )
                                }
                            })
                        t.text = data?.playlist?.name
                        val list = mutableListOf<Item>()
                        var rk = 1
                        if (data?.playlist?.tracks == null) return@runOnUiThread
                        for (i in data.playlist?.tracks!!) {
                            list.add(MusicItem(this, i.id, i.name, i.ar?.get(0)?.name, rk++))
                        }
                        recyclerView.layoutManager = LinearLayoutManager(this)
                        recyclerView.withItems(list)
                    }
                    Status.INV -> Toast.makeText(this, "Internet Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}