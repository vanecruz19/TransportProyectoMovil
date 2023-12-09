package com.example.transportproyecto.service

import com.example.transportproyecto.model.Foro
import com.example.transportproyecto.model.request.LoginRequest
import com.example.transportproyecto.model.request.RegisterRequest
import com.example.transportproyecto.model.request.UserRequest
import com.example.transportproyecto.model.response.ContentResponse
import com.example.transportproyecto.model.response.LoginResponse
import com.example.transportproyecto.model.response.RegisterResponse
import com.example.transportproyecto.model.response.RouteResponse
import com.example.transportproyecto.model.response.User
import com.example.transportproyecto.model.response.UserResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Response
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






    //para obtener un perfil de usuario en especifico
    @GET("api/users/{userId}")
    fun getUserPerfil(@Path("userId") userId: String): Call<User>


    //EDITAR PERFIL

    @PUT("api/users/{userId}")
    fun updatePerfil(@Body userRequest: UserRequest, @Path("userId") userId: String): Call<UserResponse>

    @PUT("/users/{userId}")
    fun updateUserPerfil(@Path("userId") userId: String, @Body user: User): Call<User>


    //Sirve para actualizar un contenido existente.
    fun updateContent(
        @Path("id") id: String, // Capturar la ID como un parámetro de ruta
        @Part("user_id") userId: RequestBody ): Call<ContentResponse>


    //Sirve para crear un nuevo contenido.
    fun createContent(
        @Part("user_id") userId: RequestBody
    ): Call<ContentResponse>








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


    ///Datos del foro
    @GET("/api/comments")
    suspend fun obtenerComment(): Response<List<Foro>>

    @GET("/api/comments")
    suspend fun obtenerComment(
        @Query("character") nombre: String
    ): Response<List<Foro>>

    @GET("/v2/directions/driving-car")
    suspend fun getRoute(
        @Query("api_key") key: String,
        @Query("start", encoded = true) start: String,
        @Query("end", encoded = true) end: String
    ):Response<RouteResponse>
}


