package com.android.smachar.data.api
import com.android.smachar.data.remote.ArticleDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {
    @GET("top-headlines")
    suspend fun getNewsArticle(
        @Query("country") country:String="us",
        @Query("apiKey") apikey:String="f11bedb84c254537bef81192f7d0b0bc"
    ) : Response<ArticleDTO>
}