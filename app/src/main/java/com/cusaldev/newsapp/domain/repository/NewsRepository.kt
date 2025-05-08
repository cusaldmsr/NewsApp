package com.cusaldev.newsapp.domain.repository

import com.cusaldev.newsapp.domain.model.ArticleDto
import com.cusaldev.newsapp.domain.model.Source
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getTopHeadlines(source: String): ArticleDto
}