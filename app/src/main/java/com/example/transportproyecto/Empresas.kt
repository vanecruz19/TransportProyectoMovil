package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.databinding.ActivityEmpresasBinding
import com.example.transportproyecto.databinding.ActivityLoginBinding
import com.example.transportproyecto.databinding.ActivityMainBinding

class Empresas : AppCompatActivity() {
    private lateinit var binding: ActivityEmpresasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empresas)
        binding = ActivityEmpresasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickListener()


        clickListener()

        binding.VerTranspuvenza.setOnClickListener{
            startActivity(Intent(this@Empresas, RutasTranspuvenza::class.java))
        }

        binding.VerSotraCauca.setOnClickListener{
            startActivity(Intent(this@Empresas,     RutasSotracauca::class.java))
        }

        binding.VerTranslibertad.setOnClickListener{
            startActivity(Intent(this@Empresas,     RutasTraslibertad::class.java))
        }

        binding.VerTrastambo.setOnClickListener{
            startActivity(Intent(this@Empresas,     RutasTrastambo::class.java))
        }


    }

    private fun clickListener() {
        binding.VerTranspuvenza.setOnClickListener{

        }
    }
}

