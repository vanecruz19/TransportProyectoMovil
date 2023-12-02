package com.example.transportproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.client.ApiClient
import com.example.transportproyecto.model.response.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Editar_Perfil : AppCompatActivity() {

    // Obtén la instancia de ApiService
    private val apiService = ApiClient.getApiService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil)

        // Ejemplo de llamada para obtener el perfil del usuario actual
        val userId = "123" // Reemplaza con la lógica para obtener el ID del usuario actual
        getUserProfile(userId)
    }

    private fun getUserProfile(userId: String) {
        val call = apiService.getUserProfile(userId)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    // Actualiza la interfaz de usuario con los datos del perfil obtenidos

                    // Ejemplo de llamada para actualizar el perfil
                    if (user != null) {
                        updateUserProfile(userId, user)
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // Maneja la falla en la solicitud
            }
        })
    }

    private fun updateUserProfile(userId: String, updatedUser: User) {
        // Aquí deberías tener la lógica para actualizar el perfil
        // Puedes abrir una nueva actividad o fragmento para que el usuario ingrese los nuevos datos
        // y luego llamar a esta función para actualizar el perfil.
    }
}
