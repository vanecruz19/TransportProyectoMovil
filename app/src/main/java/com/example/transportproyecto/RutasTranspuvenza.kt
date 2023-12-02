package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.databinding.ActivityMapasPuvenzaBinding
import com.example.transportproyecto.databinding.ActivityRutasTranspuvenzaBinding

class RutasTranspuvenza : AppCompatActivity() {

    private lateinit var binding: ActivityRutasTranspuvenzaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutas_transpuvenza)

        binding = ActivityRutasTranspuvenzaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()

        binding.BtnMapaPuvenza.setOnClickListener {
            startActivity(Intent(this@RutasTranspuvenza, MapasPuvenza::class.java))
        }

    }

    private fun clickListener() {
        binding.BtnMapaPuvenza.setOnClickListener{

        }
    }
    }
