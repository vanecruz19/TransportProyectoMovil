package com.example.transportproyecto.model.response

data class LoginResponse(
    val message: String,
    val access_token: String,
    val token_type: String,
    val user: User
)
