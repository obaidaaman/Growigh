package com.example.growgh.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.growgh.Model.User
import com.example.growgh.R
import com.example.growgh.databinding.ActivityLoginBinding
import com.example.growgh.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivitySignUpBinding.inflate(layoutInflater)

        firebaseAuth= FirebaseAuth.getInstance()
        val db = Firebase.firestore
        setContentView(binding.root)

       binding.btnSetup.setOnClickListener {

           val username = binding.usernameEditText.text.toString()

           val fullName = binding.fullNameEditText.text.toString()

           val email = binding.emailEditText.text.toString()

           val password = binding.passwordEditText.text.toString()




           if (binding.emailEditText.text.toString() !=""

               && binding.usernameEditText.text.toString() !=""

               && binding.passwordEditText.text.toString() !="" ){

               val user = hashMapOf(
                   "username" to username,
                   "full name" to fullName,
                   "email" to email,
                   "password" to password
               )


               binding.progressBar.visibility= View.VISIBLE



                       firebaseAuth.createUserWithEmailAndPassword(email,password)



                           .addOnCompleteListener {



                               if (it.isSuccessful){
                                   val userDetails = User(binding.usernameEditText.text.toString(),

                                       binding.emailEditText.text.toString(),FirebaseAuth.getInstance().uid!!,binding.passwordEditText.text.toString())

                                    FirebaseFirestore.getInstance().collection("users").document(userDetails.uid).set(userDetails)


                                   startActivity(Intent(this@SignUpActivity,MainActivity::class.java))
                                   finish()
                                   Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                               }
                           }
                           .addOnFailureListener {
                               Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                               binding.progressBar.visibility=View.GONE
                           }

                   .addOnFailureListener {
                       Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                       Toast.makeText(this, "Account error", Toast.LENGTH_SHORT).show()
                       binding.progressBar.visibility=View.GONE
                   }

           }
           }


        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
            finish()
        }

    }
}