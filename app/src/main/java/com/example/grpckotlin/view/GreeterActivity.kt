package com.example.grpckotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.grpckotlin.adapters.GreeterFragmentsViewPagerAdapter
import com.example.grpckotlin.databinding.ActivityGreeterBinding


class GreeterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGreeterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGreeterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val greeterFragmentsViewPagerAdapter = GreeterFragmentsViewPagerAdapter(supportFragmentManager)
        binding.greeterViewPager.adapter = greeterFragmentsViewPagerAdapter

        binding.greeterTabLayout.setupWithViewPager(binding.greeterViewPager)
    }
}