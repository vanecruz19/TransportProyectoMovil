package com.example.transportproyecto.model.response

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserResponse (
    val id: String,
    val profile_image: String,
    val usuario: String,
    val email: String,
    val created_at: String,
    val updated_at: String,
)