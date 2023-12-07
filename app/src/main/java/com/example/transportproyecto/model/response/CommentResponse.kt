package com.example.transportproyecto.model.response

import com.google.gson.annotations.SerializedName
import org.w3c.dom.Comment

data class CommentResponse(
    @SerializedName("listaComment") var listaComment: ArrayList<Comment>
)



