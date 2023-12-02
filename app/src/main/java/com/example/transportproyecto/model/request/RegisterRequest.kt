package com.example.transportproyecto.model.request

data class RegisterRequest(
    val usuario: String,
    val email: String,
    val password: String,
    val passwordConfirm: String,
)
