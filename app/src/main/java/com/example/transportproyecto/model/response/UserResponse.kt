package com.example.transportproyecto.model.response

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserResponse (
    val id: String,
    val user: String,
    val email: String,
)