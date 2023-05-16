package com.android.smachar.data.remote

import com.android.smachar.domain.model.Articles

data class ArticleDTO(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
