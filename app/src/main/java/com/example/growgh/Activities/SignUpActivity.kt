package com.example.growgh.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.growgh.R
import com.example.growgh.databinding.ActivityLoginBinding
import com.example.growgh.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySignUpBinding.inflate(layoutInflater)

        firebaseAuth= FirebaseAuth.getInstance()

        setContentView(binding.root)

       binding.btnSetup.setOnClickListener {
           val username = binding.usernameEditText.text.toString()
           val email = binding.emailEditText.text.toString()
           val password = binding.passwordEditText.text.toString()
           if (binding.emailEditText.text.toString() !="" && binding.usernameEditText.text.toString() !="" &&
               binding.usernameEditText.text.toString() !="" ){
               binding.progressBar.visibility= View.VISIBLE
               firebaseAuth.createUserWithEmailAndPassword(email,password)
                   .addOnCompleteListener {
                       if (it.isSuccessful){
                           startActivity(Intent(this@SignUpActivity,MainActivity::class.java))
                           finish()
                           Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                       }
                   }
           }
           }


        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
            finish()
        }

    }
}