package com.example.transportproyecto.service

import com.example.transportproyecto.model.request.LoginRequest
import com.example.transportproyecto.model.request.RegisterRequest
import com.example.transportproyecto.model.response.LoginResponse
import com.example.transportproyecto.model.response.RegisterResponse
import com.example.transportproyecto.model.response.User
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @POST("/api/login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("/api/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>


    @GET("api/delete/")
    fun deleteUser(): Call<User>

    @GET("api/users/{userId}")
    fun getUserProfile(@Path("userId") userId: String): Call<User>

        @PUT("/users/{userId}")
        fun updateUserProfile(@Path("userId") userId: String, @Body user: User): Call<User>


        @GET("comments")
        fun getComments(): Call<List<Comment>>

        @POST("comments")
        fun createComment(@Body comment: Comment): Call<Comment>

        @GET("comments/{commentId}")
        fun getComment(@Path("commentId") commentId: String): Call<Comment>

        @PUT("comments/{commentId}")
        fun updateComment(@Path("commentId") commentId: String, @Body comment: Comment): Call<Comment>

        @DELETE("comments/{commentId}")
        fun deleteComment(@Path("commentId") commentId: String): Call<Void>

}

