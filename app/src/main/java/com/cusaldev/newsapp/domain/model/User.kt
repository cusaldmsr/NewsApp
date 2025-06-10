package com.cusaldev.newsapp.domain.model

data class User(
    val uid: String = "",
    val email: String = "",
    val name: String? = null,
    val photoUrl: String? = null
)
