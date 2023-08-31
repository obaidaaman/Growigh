package com.example.growgh.Activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.growgh.Model.User
import com.example.growgh.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var  sharedPreferences: SharedPreferences

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        firebaseAuth= FirebaseAuth.getInstance()


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

        val currentUser = FirebaseAuth.getInstance().currentUser
        val userDocument = FirebaseFirestore.getInstance().collection("users").document(currentUser!!.uid)
        userDocument.get().addOnSuccessListener { docSnapshot ->
            val user = docSnapshot.toObject(User::class.java)
            if (user!= null){
                binding.txtName.text="Welome, ${user.name}"

        }
        }

        binding.btnUploads.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }
        binding.btnFeeds.setOnClickListener {
            startActivity(Intent(this@MainActivity, FeedsActivity::class.java))
        }

        binding.imgSignOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }


}
