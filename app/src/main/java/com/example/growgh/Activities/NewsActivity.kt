package com.example.growgh.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.growgh.Adapter.NewsAdapter
import com.example.growgh.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class NewsActivity : AppCompatActivity() {

  private lateinit var tab: TabLayout
  private   var toolbar: Toolbar? = null
    private lateinit  var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_news)

        setSupportActionBar(toolbar)

        tab = findViewById(R.id.includeTab)

        toolbar = findViewById(R.id.toolbar)

            viewPager= findViewById(R.id.fragmentContainer)

        val adapter = NewsAdapter(supportFragmentManager,lifecycle)

        viewPager.adapter = adapter;

        TabLayoutMediator(tab,viewPager){tab : TabLayout.Tab, position : Int ->
            tab.text = adapter.titles[position]
        }.attach()

    }
}