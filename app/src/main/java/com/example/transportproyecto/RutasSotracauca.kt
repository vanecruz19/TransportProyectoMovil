package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.databinding.ActivityRutasSotracaucaBinding
import com.example.transportproyecto.databinding.ActivityRutasTraslibertadBinding

class RutasSotracauca : AppCompatActivity() {

    private lateinit var binding: ActivityRutasSotracaucaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutas_sotracauca)

        binding = ActivityRutasSotracaucaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()

        binding.ButtonSotra.setOnClickListener {
            startActivity(Intent(this@RutasSotracauca, MapasSotracauca::class.java))
        }

    }

    private fun clickListener() {
        binding.ButtonSotra.setOnClickListener{

        }
    }

}