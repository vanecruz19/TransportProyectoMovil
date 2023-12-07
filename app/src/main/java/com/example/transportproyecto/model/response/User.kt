package com.example.transportproyecto.model.response

data class User(
    val id: Int,
    val profile_image: String,
    val usuario: String,
    val email: String,
    val created_at: String,
    val updated_at: String?
)