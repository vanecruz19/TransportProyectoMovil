package com.example.transportproyecto.model

import com.google.gson.annotations.SerializedName

data class Foro(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("image")
    val image: String,
)
