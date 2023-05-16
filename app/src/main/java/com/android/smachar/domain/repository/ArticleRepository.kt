package com.android.smachar.domain.repository

import com.android.smachar.domain.model.Articles

interface ArticleRepository {
    suspend fun getNewsArticle():List<Articles>
}