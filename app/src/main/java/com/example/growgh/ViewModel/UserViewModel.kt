package com.example.growgh.ViewModel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserViewModel(): ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    fun fetchUserData(){
        val user = auth.currentUser
        val userDocumentRef = db.collection("users").document(user!!.uid)

        userDocumentRef.get()
            .addOnSuccessListener {docSnapshot ->
                if (docSnapshot.exists()){
                    val username = docSnapshot.get("username")

                }
            }

    }
}