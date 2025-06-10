package com.cusaldev.newsapp.data.repository

import com.cusaldev.newsapp.data.remort.NewApiService
import com.cusaldev.newsapp.domain.model.Article
import com.cusaldev.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newApiService: NewApiService) : NewsRepository{
    override suspend fun getTopHeadlines(): Flow<Result<List<Article>>> = flow {
        try {
            val result = newApiService.getTopHeadlines()
            val articles = result.articles
            emit(Result.success(articles))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    override suspend fun searchNews(query: String): Flow<Result<List<Article>>> = flow{
        try {
            val result = newApiService.searchNews(query)
            val articles = result.articles
            emit(Result.success(articles))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}