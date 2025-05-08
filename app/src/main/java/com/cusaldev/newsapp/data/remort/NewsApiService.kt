package com.cusaldev.newsapp.data.remort

import com.cusaldev.newsapp.domain.model.ArticleDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    companion object {
        const val API_KEY = "cd90c17332664dc0b42b9602750f0342"
    }

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") source: String = "techcrunch",
        @Query("apiKey") apiKey: String = API_KEY
    ):ArticleDto
}