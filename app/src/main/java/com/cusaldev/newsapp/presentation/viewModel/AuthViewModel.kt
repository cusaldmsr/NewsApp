package com.cusaldev.newsapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cusaldev.newsapp.domain.usecase.SignInUseCase
import com.cusaldev.newsapp.domain.usecase.SignUpUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> get() = _authState

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result = signInUseCase(email, password)
            _authState.value = when {
                result.isSuccess -> AuthState.Success(result.getOrNull()!!)
                result.isFailure -> {
                val error = result.exceptionOrNull()?.message ?: "Unknown error"
                AuthState.Error(error)
                }
                else -> AuthState.Error("Unknown error")
            }
        }
    }
    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading

            val result = signUpUseCase(email, password)
            _authState.value = when {
                result.isSuccess -> AuthState.Success(result.getOrNull()!!)
                result.isFailure -> {
                    val error = result.exceptionOrNull()?.message ?: "Unknown error"
                    AuthState.Error(error)
                }
                else -> AuthState.Error("Unknown error")
            }
        }
    }
}

sealed class AuthState{
    object Loading : AuthState()
    data class Success(val user: FirebaseUser) : AuthState()
    data class Error(val message: String) : AuthState()
}