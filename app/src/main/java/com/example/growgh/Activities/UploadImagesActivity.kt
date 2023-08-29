package com.example.growgh.Activities

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


import com.example.growgh.databinding.ActivityUploadImagesBinding

class UploadImagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadImagesBinding
    companion object {
        private const val REQUEST_PERMISSION = 123
    }
    private   var contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView2.setImageURI(it)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityUploadImagesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)
                               !=
              PackageManager.PERMISSION_GRANTED  ){


            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                REQUEST_PERMISSION)


        }




        binding.imgback.setOnClickListener {
            onBackPressed()

        }

        binding.appCompatButton2.setOnClickListener {
            contract.launch("image/*")

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_PERMISSION ->{
                if (grantResults.isNotEmpty()&& grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission is granted", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}