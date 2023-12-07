package com.example.transportproyecto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transportproyecto.databinding.ActivityMainBinding

class ContentPostActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

}}