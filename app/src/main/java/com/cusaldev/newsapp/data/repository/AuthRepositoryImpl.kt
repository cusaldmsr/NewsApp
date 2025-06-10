package com.cusaldev.newsapp.data.repository

import com.cusaldev.newsapp.domain.model.User
import com.cusaldev.newsapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : AuthRepository {
    override suspend fun signIn(
        email: String,
        password: String
    ): Result<FirebaseUser> {
        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            result.user?.let {
                return Result.success(it)
            }
            return Result.failure(Exception("User not found"))
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun signUp(
        email: String,
        password: String
    ): Result<FirebaseUser> {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }

    override fun getCurrentUser(): FirebaseUser? {
        TODO("Not yet implemented")
    }
}