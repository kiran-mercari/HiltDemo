package com.example.hiltdemo

import javax.inject.Inject

interface GetArticleUseCase {
    suspend operator fun invoke(): Result<List<Article>>
}

class GetArticleUseCaseImpl @Inject constructor(
    private val repository: ArticleRepository
) : GetArticleUseCase {
    override suspend fun invoke(): Result<List<Article>> {
        return repository.getArticles()
    }
}