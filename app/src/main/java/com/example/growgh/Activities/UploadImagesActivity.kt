package com.example.growgh.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import androidx.activity.result.contract.ActivityResultContracts
import com.example.growgh.R
import com.example.growgh.databinding.ActivityUploadImagesBinding

class UploadImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadImagesBinding

    private   var contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView2.setImageURI(it)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityUploadImagesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imgback.setOnClickListener {
            onBackPressed()

        }

        binding.appCompatButton2.setOnClickListener {
            contract.launch("image/*")

        }

    }


}