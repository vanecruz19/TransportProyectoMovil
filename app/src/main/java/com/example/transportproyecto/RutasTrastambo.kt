package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.databinding.ActivityRutasTraslibertadBinding
import com.example.transportproyecto.databinding.ActivityRutasTrastamboBinding

class RutasTrastambo : AppCompatActivity() {

    private lateinit var binding: ActivityRutasTrastamboBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutas_trastambo)

        binding = ActivityRutasTrastamboBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()

        binding.Buttontrastambo.setOnClickListener {
            startActivity(Intent(this@RutasTrastambo, MapasTrastambo::class.java))
        }

    }

    private fun clickListener() {
        binding.Buttontrastambo.setOnClickListener{

        }
    }
}