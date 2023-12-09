package com.example.transportproyecto


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity5 : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var btnRoute1: Button
    private lateinit var btnRoute2: Button

    private var poly: Polyline? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        btnRoute1 = findViewById(R.id.btnRoute1)
        btnRoute2 = findViewById(R.id.btnRoute2)

        btnRoute1.setOnClickListener {
            showRoute("Ruta 1", LatLng(2.4890, -76.5591), LatLng(2.4260, -76.6040))
        }

        btnRoute2.setOnClickListener {
            showRoute("Ruta 2", LatLng(2.4245, -76.6090), LatLng(2.4642, -76.6453))
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map

        // Centrar el mapa en Popayán
        val popayanLocation = LatLng(2.4442, -76.6057)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(popayanLocation, 14f))
    }

    private fun showRoute(routeName: String, start: LatLng, end: LatLng) {
        poly?.remove()
        poly = null
        Toast.makeText(this, "Mostrando $routeName", Toast.LENGTH_SHORT).show()

        CoroutineScope(Dispatchers.IO).launch {
            val polyLineOptions = PolylineOptions()
                .add(start)
                .add(end)

            runOnUiThread {
                poly = map.addPolyline(polyLineOptions)
            }
        }
    }

}