package com.cusaldev.newsapp.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cusaldev.newsapp.domain.model.Article
import com.cusaldev.newsapp.domain.usecase.NewsTopHeadlineUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val NewsTopHeadlineUseCase: NewsTopHeadlineUseCase
) : ViewModel() {

    private val _newsState = MutableStateFlow<NewsState>(NewsState.Loading)
    val newsState: StateFlow<NewsState> = _newsState

    init {
        getTopHeadlines()
    }

    fun getTopHeadlines() {
        _newsState.value = NewsState.Loading
        viewModelScope.launch {
            NewsTopHeadlineUseCase().collect { result ->
                _newsState.value = when {
                    result.isSuccess -> NewsState.Success(result.getOrNull() ?: emptyList())
                    result.isFailure -> {

                        val error = result.exceptionOrNull()?.message ?: "Unknown error"
                        NewsState.Error(error)
                    }
                    else -> NewsState.Error("Unknown error")
                }
            }
        }
    }
}

sealed class NewsState {
    object Loading : NewsState()
    data class Success(val articles: List<Article>) : NewsState()
    data class Error(val message: String) : NewsState()
}