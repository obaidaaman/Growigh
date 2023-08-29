package com.example.growgh.RetrofitUtil

import com.example.growgh.InterfaceAPI.ImageInterfaceAPi
import com.example.growgh.InterfaceAPI.VideoInterfaceAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val base_url = "https://api.unsplash.com/"
    private const val BASE_URL_Pexels_Video = "https://api.pexels.com/"

    private const val BASE_URL_Vimeo = "https://api.vimeo.com/"
    private const val ACCESS_TOKEN = "YOUR_ACCESS_TOKEN"

    val api : ImageInterfaceAPi by lazy {
Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ImageInterfaceAPi::class.java)
    }


//    val VideoApi : VideoInterfaceAPI by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL_Pexels_Video)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(VideoInterfaceAPI::class.java)
//    }
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL_Vimeo)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//        val vimeoApiService: VideoInterfaceAPI by lazy {
//            retrofit.create(VideoInterfaceAPI::class.java)
//        }
    }

