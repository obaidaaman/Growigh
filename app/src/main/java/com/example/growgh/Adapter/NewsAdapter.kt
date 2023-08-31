package com.example.growgh.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.manager.Lifecycle
import com.example.growgh.Activities.NewsActivity
import com.example.growgh.Fragments.AllNewsFragment
import com.example.growgh.Fragments.EntertainmentFragment
import com.example.growgh.Fragments.HealthFragment
import com.example.growgh.Fragments.ScienceFragment
import com.example.growgh.Fragments.SportsFragment
import com.example.growgh.Fragments.TechFragment


class NewsAdapter(fm : FragmentManager, lifecycle: androidx.lifecycle.Lifecycle) : FragmentStateAdapter(fm,lifecycle) {

    var titles = arrayOf("Home", "Sports", "Health", "Science", "Entertainment", "Technology")
    override fun getItemCount(): Int {
        return titles.size
    }

    override fun createFragment(position: Int): Fragment {
        return if (position === 0) {
          AllNewsFragment()
        } else if (position === 1) {
            SportsFragment()
        } else if (position === 2) {
            HealthFragment()
        } else if (position === 3) {
            ScienceFragment()
        } else if (position === 4) {
            EntertainmentFragment()
        } else {
            TechFragment()
        }
    }
}