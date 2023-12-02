package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.example.transportproyecto.client.ApiClient
import com.example.transportproyecto.databinding.ActivityForoBinding
import com.example.transportproyecto.databinding.ActivityMainBinding
import com.example.transportproyecto.databinding.ActivityPerfilBinding
import com.example.transportproyecto.service.ApiService
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Foro : AppCompatActivity() {

    private lateinit var binding: ActivityForoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditarForo.setOnClickListener {
            startActivity(Intent(this@Foro, Login::class.java))
        }
    }


    }
