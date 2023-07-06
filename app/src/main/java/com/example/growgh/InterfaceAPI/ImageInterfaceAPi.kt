package com.example.growgh.InterfaceAPI

import com.example.growgh.Model.ImageData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageInterfaceAPi {

    @GET("photos/random")
    fun getRandomPhotos(

        @Query("count") count: Int,

        @Query("client_id") clientId: String

    ): Call<List<ImageData>>


}