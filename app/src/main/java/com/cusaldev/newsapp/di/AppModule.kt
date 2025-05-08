package com.cusaldev.newsapp.di

import com.cusaldev.newsapp.data.remort.NewsApiService
import com.cusaldev.newsapp.data.repository.NewsRepositoryImpl
import com.cusaldev.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): NewsApiService{
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApiService: NewsApiService): NewsRepository{
        return NewsRepositoryImpl(newsApiService)
    }
}