package com.cusaldev.newsapp.domain.usecase

import com.cusaldev.newsapp.data.repository.AuthRepositoryImpl
import com.cusaldev.newsapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Result<FirebaseUser>{
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(Exception("Email or password is empty"))
        }
        return authRepository.signIn(email, password)
    }
}