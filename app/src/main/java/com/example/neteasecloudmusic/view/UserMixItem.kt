package com.example.neteasecloudmusic.view

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neteasecloudmusic.R
import com.example.neteasecloudmusic.common.Item
import com.example.neteasecloudmusic.common.ItemController
import com.example.neteasecloudmusic.common.VPAdapter
import com.example.neteasecloudmusic.view.mixes.MixFragment
import com.example.neteasecloudmusic.view.mixes.UserDataFragment

class UserMixItem(var fm: FragmentManager) : Item {
    var l1 = mutableListOf<Fragment>()
    var l2 = mutableListOf<String>()

    companion object Controller : ItemController {
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: Item) {
            holder as UserMixItem.ViewHolder
            item as UserMixItem
            item.l1.add(MixFragment())
            item.l1.add(UserDataFragment())
            item.l2.add("Music")
            item.l2.add("Me")
            holder.viewPager.adapter = VPAdapter(item.fm, item.l1, item.l2)
            holder.tabLayout.setupWithViewPager(holder.viewPager)
        }

        override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_mix_layout, parent, false))
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tabLayout = view.findViewById<TabLayout>(R.id.myTab)
        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
    }

    override val controller: ItemController
        get() = Controller
}

fun MutableList<Item>.userMixItem(fm: FragmentManager) = add(UserMixItem(fm))