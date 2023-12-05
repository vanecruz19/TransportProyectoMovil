package com.example.transportproyecto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.transportproyecto.databinding.ActivityMain2Binding
import com.example.transportproyecto.viewmodels.MainViewModel
import com.example.transportproyecto.views.adapters.ForoAdapter

class MainActivity2 : AppCompatActivity() {


    private lateinit var binding: ActivityMain2Binding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ForoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEditarForo.setOnClickListener {
            startActivity(Intent(this@MainActivity2, Login::class.java))
        }

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerView()

        viewModel.obtenerComment()

        viewModel.listaComment.observe(this) {
            adapter.listaComment = it
            adapter.notifyDataSetChanged()
        }

    }

    private fun setupRecyclerView() {
        binding.rvComment.layoutManager = GridLayoutManager(this, 2)
        adapter = ForoAdapter(this, arrayListOf())
        binding.rvComment.adapter = adapter
    }

    private fun ocultarTeclado() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}