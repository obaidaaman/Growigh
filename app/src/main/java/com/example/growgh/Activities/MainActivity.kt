package com.example.growgh.Activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.growgh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

         sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val isFirstTime = sharedPreferences.getBoolean("PREF_FIRST_TIME", true)

        if (isFirstTime) {

            startActivity(Intent(this@MainActivity, AboutUsActivity::class.java))

            Animatoo.animateCard(this)

            finish()

        } else {

            setContentView(binding.root)

        }
        binding.btnUploads.setOnClickListener {
            startActivity(Intent(this, UploadImagesActivity::class.java))
        }
        binding.btnFeeds.setOnClickListener {
            startActivity(Intent(this@MainActivity, FeedsActivity::class.java))
        }

    }


}
