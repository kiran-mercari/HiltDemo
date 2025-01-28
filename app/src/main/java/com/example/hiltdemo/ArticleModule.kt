package com.example.hiltdemo

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticleModule {
    @Binds
    abstract fun providesGetArticleUseCase(
        impl: GetArticleUseCaseImpl
    ): GetArticleUseCase

    @Binds
    abstract fun providesArticleRepository(
        impl: ArticleRepositoryImpl
    ): ArticleRepository

    companion object {
        @Provides
        fun provideArticleApiService(
            retrofit: Retrofit
        ): ArticleApiService = retrofit.create(ArticleApiService::class.java)
    }
}