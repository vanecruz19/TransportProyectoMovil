package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()

        binding.ButtonNosotros.setOnClickListener {
            startActivity(Intent(this@MainActivity, Nosotros::class.java))
        }

        binding.ButtonEmpresas.setOnClickListener {
            startActivity(Intent(this@MainActivity, Empresas::class.java))
        }

        binding.ButtonForo.setOnClickListener {
            startActivity(Intent(this@MainActivity, MainActivity2::class.java))
        }

        binding.ButtonConfig.setOnClickListener {
            startActivity(Intent(this@MainActivity, Config::class.java))
        }

        binding.ButtonPerfil.setOnClickListener {
            startActivity(Intent(this@MainActivity, Perfil::class.java))
        }






    }

    private fun clickListener() {
        binding.ButtonNosotros.setOnClickListener{


        }
    }

    }
