package com.example.hiltdemo

import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApiService {
    @GET("/v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): ArticleResponse
}

data class ArticleResponse(
    val status: String,
    val articles: List<Article>
)

private const val API_KEY = "c03144e64d9545439fdfee19d4603469"