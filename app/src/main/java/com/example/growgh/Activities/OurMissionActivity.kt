package com.example.growgh.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.growgh.databinding.ActivityOurMissionBinding

class OurMissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOurMissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding=ActivityOurMissionBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val editor = sharedPreferences.edit()
        editor.putBoolean("PREF_FIRST_TIME", false)

        editor.apply()

        binding.imgButton.setOnClickListener {
            startActivity(Intent(this,OurVisionActivity::class.java))
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