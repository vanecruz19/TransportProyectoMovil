package com.example.transportproyecto.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transportproyecto.client.RetrofitClient
import com.example.transportproyecto.model.Foro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {



    private var _listaComment = MutableLiveData<List<Foro>>()
    val listaComment: LiveData<List<Foro>> get() = _listaComment

    fun obtenerComment() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.apiService.obtenerComment()
            withContext(Dispatchers.Main) {
                Log.d("API", response.body().toString())
                _listaComment.value = response.body()
            }
        }
    }

    fun obtenerComment(personaje: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.apiService.obtenerComment(personaje)
            withContext(Dispatchers.Main) {
                Log.d("API", response.body().toString())
                _listaComment.value = response.body()
            }
        }
    }



}