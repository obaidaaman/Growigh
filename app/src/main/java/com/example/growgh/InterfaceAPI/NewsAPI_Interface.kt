package com.example.growgh.InterfaceAPI


import com.example.growgh.Model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI_Interface {

    companion object{
        const val BASE_URL = "https://newsapi.org/v2/"

    }

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country")  country: String,
        @Query("pageSize")  pageSize: Int,
        @Query("apiKey")  apiKey: String
    ) : Call<NewsData>

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String?
    ): Call<NewsData>?

}