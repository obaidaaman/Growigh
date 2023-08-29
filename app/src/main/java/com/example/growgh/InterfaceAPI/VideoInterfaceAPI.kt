package com.example.growgh.InterfaceAPI

import com.example.growgh.Model.PexelsVideo
import com.example.growgh.Model.PexelsVideoResponse
import com.example.growgh.Model.VideoResponse
import retrofit2.Call

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface VideoInterfaceAPI {

    @GET("videos")
     fun getVideos(
        @Query("category") category: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
        @Query("acces_token") accessToken: String


    ): Call<List<VideoResponse>>
}