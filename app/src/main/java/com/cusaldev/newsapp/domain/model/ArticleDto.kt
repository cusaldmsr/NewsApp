package com.cusaldev.newsapp.domain.model

data class ArticleDto(
    val status: String,
    val totalResults: Long,
    val articles: List<Article>
)
