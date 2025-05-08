package com.cusaldev.newsapp.domain.usecase

import com.cusaldev.newsapp.domain.model.ArticleDto
import com.cusaldev.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class NewsTopHeadlineUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke() : ArticleDto = newsRepository.getTopHeadlines()
}