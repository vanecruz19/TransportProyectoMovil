package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.databinding.ActivityMapasTraslibertadBinding
import com.example.transportproyecto.databinding.ActivityRutasTranspuvenzaBinding
import com.example.transportproyecto.databinding.ActivityRutasTraslibertadBinding

class RutasTraslibertad : AppCompatActivity() {
    private lateinit var binding: ActivityRutasTraslibertadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutas_traslibertad)

        binding = ActivityRutasTraslibertadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()

        binding.ButtonTransLibertad.setOnClickListener {
            startActivity(Intent(this@RutasTraslibertad, MapasTraslibertad::class.java))
        }

    }

    private fun clickListener() {
        binding.ButtonTransLibertad.setOnClickListener{

        }
    }
    }
