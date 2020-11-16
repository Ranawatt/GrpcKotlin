package com.example.grpckotlin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.grpckotlin.view.GreeterFragmentOne
import com.example.grpckotlin.view.GreeterFragmentTwo

class GreeterFragmentsViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> GreeterFragmentOne()
            else -> GreeterFragmentTwo()
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Fragment 1"
            else -> "Fragment 2"
        }
    }
}