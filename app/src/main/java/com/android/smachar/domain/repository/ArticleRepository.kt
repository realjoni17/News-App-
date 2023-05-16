package com.android.smachar.domain.repository

import com.android.smachar.domain.model.Article

interface ArticleRepository {
    suspend fun getNewsArticle():List<Article>
}