package com.android.smachar.data.repository

import android.util.Log
import com.android.smachar.data.api.ArticleApi
import com.android.smachar.data.remote.todomain
import com.android.smachar.domain.model.Articles
import com.android.smachar.domain.repository.ArticleRepository
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(private val apiService:ArticleApi):ArticleRepository,
    SafeApiRequest() {
    override suspend fun getNewsArticle(): List<Articles> {
        val response = safeApiRequest { apiService.getNewsArticle() }
        return response?.articles?.todomain()!!

    }
}



abstract class SafeApiRequest {

    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val responseErr = response.errorBody()?.string()
            val message = StringBuilder()
            responseErr.let {
                try {
                    message.append(JSONObject(it).getString("error"))
                } catch (e: JSONException) {
                }
            }
            Log.d("TAG", "safeApiRequest: ${message.toString()}")
            throw Exception(message.toString())
        }
    }

}