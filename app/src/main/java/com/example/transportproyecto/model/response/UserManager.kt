package com.example.transportproyecto.model.response

object UserManager {
    private var userId: Int = -1

    fun getUserId(): Int {
        return userId
    }

    fun setUserId(id: Int) {
        userId = id
    }
}
