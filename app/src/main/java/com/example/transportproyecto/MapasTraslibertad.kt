package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportproyecto.databinding.ActivityMainBinding
import com.example.transportproyecto.databinding.ActivityMapasTraslibertadBinding

class MapasTraslibertad : AppCompatActivity() {

    private lateinit var binding: ActivityMapasTraslibertadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapas_traslibertad)

    }
}