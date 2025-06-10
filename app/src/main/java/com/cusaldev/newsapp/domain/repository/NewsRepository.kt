package com.cusaldev.newsapp.domain.repository

import com.cusaldev.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getTopHeadlines(): Flow<Result<List<Article>>>
    suspend fun searchNews(query: String): Flow<Result<List<Article>>>
}