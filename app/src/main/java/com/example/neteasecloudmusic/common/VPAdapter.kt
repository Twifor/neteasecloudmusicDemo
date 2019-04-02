package com.example.neteasecloudmusic.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class VPAdapter(fm: FragmentManager, var l1: List<Fragment>, var l2: List<String>) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? {
        return l2[position]
    }

    override fun getItem(p0: Int): Fragment {
        return l1[p0]
    }

    override fun getCount(): Int {
        return l2.size
    }
}