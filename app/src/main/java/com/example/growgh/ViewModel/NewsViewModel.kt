package com.example.growgh.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.growgh.Model.Article
import com.example.growgh.Model.NewsData
import com.example.growgh.RetrofitUtil.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsViewModel : ViewModel() {
    private val _categoryNewsLiveData = MutableLiveData<List<Article>>()
    val CategorynewsLiveData: LiveData<List<Article>> = _categoryNewsLiveData
    val _newsLiveData = MutableLiveData<List<Article>>()


    fun fetchCategoryNews(country: String, category: String, pageSize: Int,apiKey: String){
        viewModelScope.launch {
            RetrofitInstance.Newsapi.getCategoryNews(country,category, pageSize, apiKey)?.enqueue(object : Callback<NewsData?> {
                override fun onResponse(call: Call<NewsData?>, response: Response<NewsData?>) {
                    if (response.isSuccessful){
                     _categoryNewsLiveData.postValue(response.body()?.articles)
                    }
                }

                override fun onFailure(call: Call<NewsData?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

    fun fetchNews( country:  String, pageSize: Int,apiKey: String){
        viewModelScope.launch {
            RetrofitInstance.Newsapi.getNews(country, pageSize, apiKey).enqueue(object : Callback<NewsData?> {
                override fun onResponse(call: Call<NewsData?>, response: Response<NewsData?>) {
                    if (response.isSuccessful){
                        _newsLiveData.postValue(response.body()?.articles)
                    }
                }

                override fun onFailure(call: Call<NewsData?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

    fun observeCategoryNewsData() : LiveData<List<Article>>{
        return _categoryNewsLiveData
    }
 fun observeNewsData() : LiveData<List<Article>>{
        return _newsLiveData
    }

}