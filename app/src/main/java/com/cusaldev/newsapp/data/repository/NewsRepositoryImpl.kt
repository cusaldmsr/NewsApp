package com.cusaldev.newsapp.data.repository

import com.cusaldev.newsapp.data.remort.NewsApiService
import com.cusaldev.newsapp.domain.model.ArticleDto
import com.cusaldev.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsRepository{
    override suspend fun getTopHeadlines(source: String): ArticleDto {
        return newsApiService.getTopHeadlines()
    }
}