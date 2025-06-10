package com.cusaldev.newsapp.di

import com.cusaldev.newsapp.data.remort.NewApiService
import com.cusaldev.newsapp.data.repository.AuthRepositoryImpl
import com.cusaldev.newsapp.domain.repository.AuthRepository
import com.cusaldev.newsapp.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindNewsRepository(newApiService: NewApiService): NewsRepository
}