package com.cusaldev.newsapp.domain.usecase

import com.cusaldev.newsapp.domain.model.Article
import com.cusaldev.newsapp.domain.model.ArticleDto
import com.cusaldev.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsTopHeadlineUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke() :
            Flow<Result<List<Article>>> = newsRepository.getTopHeadlines()
}