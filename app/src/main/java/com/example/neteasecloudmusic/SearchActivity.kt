package com.example.neteasecloudmusic

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.neteasecloudmusic.common.Status
import com.example.neteasecloudmusic.common.withItems
import com.example.neteasecloudmusic.network.music.MusicFactory
import com.example.neteasecloudmusic.view.music.MusicItem
import kotlinx.android.synthetic.main.search_layout.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.search_layout)
        search.setOnClickListener {
            val key = editText.text.toString()
            if (key == "") Toast.makeText(this, "The keywords can't be empty!!", Toast.LENGTH_SHORT).show()
            else {
                MusicFactory.search(key) { status, searchDataBean ->
                    runOnUiThread {
                        when (status) {
                            Status.NETERR -> Toast.makeText(this, "NetWork Error", Toast.LENGTH_SHORT).show()
                            Status.OK -> {
                                val list = mutableListOf<MusicItem>()
                                var rk = 1
                                for (x in searchDataBean?.result?.songs!!) {
                                    list.add(
                                        MusicItem(
                                            this,
                                            x.id,
                                            x.name,
                                            if (x.artists == null) "" else x.artists!![0].name,
                                            rk++
                                        )
                                    )
                                }
                                recyclerView.layoutManager = LinearLayoutManager(this)
                                recyclerView.withItems(list)
                            }
                        }
                    }

                }
            }
        }
    }
}