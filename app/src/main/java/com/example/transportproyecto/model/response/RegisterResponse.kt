package com.example.transportproyecto.model.response

data class RegisterResponse(
    val id: Int,
    val usuario: String,
    val email: String,
    val password: String,
    val passwordConfirm: String,
)
