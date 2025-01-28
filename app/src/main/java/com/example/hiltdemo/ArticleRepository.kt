package com.example.hiltdemo

import javax.inject.Inject

interface ArticleRepository {
    suspend fun getArticles(): Result<List<Article>>
}

class ArticleRepositoryImpl @Inject constructor(
    private val service: ArticleApiService
) : ArticleRepository {
    override suspend fun getArticles(): Result<List<Article>> {
        return kotlin.runCatching {
            service.getNews().articles
        }
    }
}