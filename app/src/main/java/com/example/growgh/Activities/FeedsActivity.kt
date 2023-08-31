package com.example.growgh.Activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.growgh.Adapter.ImageAdapter
import com.example.growgh.Adapter.ViewPagerAdapter
import com.example.growgh.Fragments.HomeFragment
import com.example.growgh.Fragments.MapsFragment
import com.example.growgh.Fragments.ShortsFragment
import com.example.growgh.Model.ImageData
import com.example.growgh.R
import com.example.growgh.RetrofitUtil.RetrofitInstance
import com.example.growgh.databinding.ActivityFeedsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedsBinding


    private lateinit var fragmentManager : FragmentManager

    lateinit var fragArrayList: ArrayList<Fragment>



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFeedsBinding.inflate(layoutInflater)

        fragArrayList= ArrayList()
        fragArrayList.add(HomeFragment())

        fragArrayList.add(ShortsFragment())

        fragArrayList.add(MapsFragment())

        super.onCreate(savedInstanceState)

        setContentView(binding.root)



        val adapterViewPager  = ViewPagerAdapter(this,fragArrayList)
     //   binding.mainPager.adapter= adapterViewPager
//        binding.mainPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//
//                when(position){
//                    1->{
//                        binding.bottomNavigationView.selectedItemId = R.id.btnHome
//                    }
//                    2->{
//                        binding.bottomNavigationView.selectedItemId = R.id.btnVideos
//                    }
//                    3->{
//                        binding.bottomNavigationView.selectedItemId = R.id.btnMap
//                    }
//                    else ->    binding.bottomNavigationView.selectedItemId = R.id.btnHome
//                }
//
//                binding.bottomNavigationView.selectedItemId
//                super.onPageSelected(position)
//            }
//        })

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.btnHome ->{
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.btnVideos ->{
                    replaceFragment(ShortsFragment())
                    true
                }
                R.id.btnMap ->{
                    replaceFragment(MapsFragment())
                    true
                }
                else -> false
            }

        }
        if (savedInstanceState== null){
            replaceFragment(HomeFragment())
        }



    }

private fun replaceFragment(fragment : Fragment){
    fragmentManager= supportFragmentManager
    fragmentManager.beginTransaction().replace(R.id.fragment_container_view,fragment)
        .commit()
}


}