package com.android.smachar.data.remote

import com.android.smachar.domain.model.Articles

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)


fun List<Article>.todomain():List<Articles>{
    return map{
        Articles(content = it.content,
            description = it.description,
            title = it.title,
            urlToImage = it.urlToImage)
    }
}