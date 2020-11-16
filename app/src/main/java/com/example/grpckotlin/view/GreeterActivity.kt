package com.example.grpckotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.grpckotlin.R
import com.example.grpckotlin.adapters.GreeterFragmentsViewPagerAdapter
import kotlinx.android.synthetic.main.activity_greeter.*

class GreeterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeter)


        val greeterFragmentsViewPagerAdapter = GreeterFragmentsViewPagerAdapter(supportFragmentManager)
        greeterViewPager.adapter = greeterFragmentsViewPagerAdapter

        greeterTabLayout.setupWithViewPager(greeterViewPager)
    }
}