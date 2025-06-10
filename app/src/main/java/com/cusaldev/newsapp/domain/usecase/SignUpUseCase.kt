package com.cusaldev.newsapp.domain.usecase

import com.cusaldev.newsapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Result<FirebaseUser>{
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(Exception("Email or password is empty"))
        }
        if (password.length < 6) {
            return Result.failure(Exception("Password must be at least 6 characters"))
        }
        return authRepository.signUp(email, password)
    }
}