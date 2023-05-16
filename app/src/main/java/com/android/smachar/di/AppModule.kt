package com.android.smachar.di

import com.android.smachar.data.api.ArticleApi
import com.android.smachar.data.repository.ArticleRepositoryImpl
import com.android.smachar.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
@Provides
fun provideApiService() : ArticleApi{
    return Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create()).build().create(ArticleApi::class.java)
}

    fun provideGetNewsRepo(apiService:ArticleApi):ArticleRepository{
        return ArticleRepositoryImpl(apiService = apiService)
    }
}