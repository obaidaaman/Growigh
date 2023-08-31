package com.example.growgh.Model

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)