package com.example.growgh.Activities

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.growgh.databinding.ActivityOurVisionBinding

class OurVisionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOurVisionBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityOurVisionBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()

        editor.putBoolean("PREF_FIRST_TIME", false)
        editor.apply()

        binding.imgButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            Animatoo.animateSlideLeft(this)
            finish()

        }
        binding.appCompatButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            Animatoo.animateSlideLeft(this)
            finish()
        }
    }
}