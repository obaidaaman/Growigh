package com.example.growgh.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.growgh.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAboutUsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        editor.putBoolean("PREF_FIRST_TIME", false)
        editor.apply()

        binding.appCompatButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            Animatoo.animateSlideLeft(this)
            finish()
        }
        binding.imgButton.setOnClickListener {
            startActivity(Intent(this,OurMissionActivity::class.java))
            Animatoo.animateSlideLeft(this)
            finish()
        }
    }
}