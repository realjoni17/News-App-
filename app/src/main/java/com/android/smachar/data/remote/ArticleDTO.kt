package com.android.smachar.data.remote

data class ArticleDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)