package com.example.transportproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.transportproyecto.client.ApiClient
import com.example.transportproyecto.databinding.ActivityPerfilBinding
import com.example.transportproyecto.model.response.User
import com.example.transportproyecto.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Perfil : AppCompatActivity() {

    private lateinit var binding: ActivityPerfilBinding
    private lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtén la instancia de ApiService
        val apiService = ApiClient.getApiService()

        // Ejemplo de llamada para obtener el perfil del usuario actual
        val userId = "123" // Reemplaza con la lógica para obtener el ID del usuario actual
        getUserProfile(apiService, userId)

        binding.editarPerfil.setOnClickListener {
            startActivity(Intent(this@Perfil, Editar_Perfil::class.java))
        }
    }

    private fun getUserProfile(apiService: ApiService, userId: String) {
        val call = apiService.getUserProfile(userId)
        call.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    currentUser = response.body()!!
                    updateUIWithUserData(currentUser)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // Maneja la falla en la solicitud
            }
        })
    }

    private fun updateUIWithUserData(user: User) {
        // Actualiza la interfaz de usuario con los datos del perfil obtenidos
        val nameTextView: TextView = findViewById(R.id.name)
        val emailTextView: TextView = findViewById(R.id.email)

        nameTextView.text = user.usuario
        emailTextView.text = user.email
    }
}
