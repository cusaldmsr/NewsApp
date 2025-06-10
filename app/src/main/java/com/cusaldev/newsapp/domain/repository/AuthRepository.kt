package com.cusaldev.newsapp.domain.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Result<FirebaseUser>
    suspend fun signUp(email: String, password: String): Result<FirebaseUser>
    suspend fun signOut(): Result<Unit>
    fun getCurrentUser(): FirebaseUser?
}