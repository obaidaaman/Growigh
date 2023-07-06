package com.example.growgh.RetrofitUtil

import com.example.growgh.InterfaceAPI.ImageInterfaceAPi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val base_url = "https://api.unsplash.com/"

    val api : ImageInterfaceAPi by lazy {
Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ImageInterfaceAPi::class.java)
    }

}