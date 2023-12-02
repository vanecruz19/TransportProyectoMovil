package com.example.transportproyecto.model.response

data class User(
    val id: Int,
    val usuario: String,
    val email: String,
    val password: String,
    val remember_token: String,
    val created_at: String,
    val updated_at: String?
)
