package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import java.util.TimerTask

class Bienvenidos1 : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_bienvenidos1)
            val tiempoIni: TimerTask = object : TimerTask() {
                override fun run() {
                    val intent = Intent(this@Bienvenidos1, Login::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            val tiempo = Timer()
            tiempo.schedule(tiempoIni, 4000)
        }
    }