package com.example.transportproyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.util.PatternsCompat
import com.example.transportproyecto.client.ApiClient
import com.example.transportproyecto.databinding.ActivityRegistroBinding
import com.example.transportproyecto.model.request.RegisterRequest
import com.example.transportproyecto.model.response.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    private val PASSWORDPATTERN = Pattern.compile(
        "^" +
                "(?=.*[@#$%^&+=!|°()?¡¿*.:,])" +  // at least 1 special character
                "(?=\\S+$)" +                     // no white spaces
                ".{8,}" +                         // at least 4 characters
                "$"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        register()

        binding.loginTransport.setOnClickListener {
            startActivity(Intent(this@Registro, Login::class.java))
        }


    }


    fun register() {
        binding.btnRegister.setOnClickListener {
            validate()
            getInputs()
        }
    }



    private fun getInputs()
    {
        val usuario         = binding.usuario.text.toString()
        val email           = binding.email.text.toString()
        val password        = binding.contrasena.text.toString()
        val passwordConfirm = binding.confirmarContrasena.text.toString()

        if(usuario.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty())
        {
            if(validateEmail() and  validatePassword() and validateNameAndDate())
            {
                registerUser(usuario, email, password, passwordConfirm)
            }
        }
        else
        {
            Toast.makeText(this@Registro, "Completa los campos", Toast.LENGTH_LONG).show()
        }
    }

    private fun registerUser(usuario: String, email: String, password: String, passwordConfirm: String) {
        val registerRequest = RegisterRequest(usuario, email, password, passwordConfirm)
        val apiCall = ApiClient.getApiService().registerUser(registerRequest)
        apiCall.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if(response.isSuccessful)
                {
                    move()
                    finish()
                }
                else
                {
                    Toast.makeText(this@Registro, "Sucedio un error inesperado o corrige tus credenciales", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(this@Registro, "Ha ocurrido un error inesperado ", Toast.LENGTH_LONG).show()
            }

        })


    }

    private fun move() {
        startActivity(Intent(this@Registro, Login::class.java))
        Toast.makeText(this@Registro, "Registro exitoso!!!", Toast.LENGTH_LONG).show()
    }

    private fun validate() {
        val result = arrayOf(validateEmail(), validatePassword(), validateNameAndDate())
        if(false in result)
        {
            return

        }
    }

    private fun validateEmail():Boolean {
        val email = binding.email.text.toString()
        return if(email.isEmpty()){
            binding.email.error = "El campo del correo no puede estar vacio"
            false
        }else if(!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.email.error = "Por favor ingresa un correo valido"
            false
        } else {
            binding.email.error = null
            true
        }
    }

    private fun validateNameAndDate(): Boolean {
        val name = binding.usuario.text.toString()
        return if(name.isEmpty()) {
            binding.usuario.error = "El campo no puede estar vacio"
            false
        } else {
            binding.usuario.error = null
            true
        }
    }

    private fun validatePassword(): Boolean {
        val password = binding.contrasena.text.toString()
        val passwordConfirmation = binding.confirmarContrasena.text.toString()

        return if(password != passwordConfirmation)
        {
            binding.contrasena.error = "Las contraseñas no coinciden"
            binding.confirmarContrasena.error = "Las contraseñas no coinciden"
            false
        }
        else if(password.isEmpty() and passwordConfirmation.isEmpty())
        {
            binding.contrasena.error = "El campo contraseña no debe estar vacio"
            binding.confirmarContrasena.error = "El campo contraseña no debe estar vacio"
            false
        }
        else if (password.length < 8) {
            binding.contrasena.error = ("La contraseña debe contener al menos 8 caracteres")
            binding.confirmarContrasena.error = ("La contraseña debe contener al menos 8 caracteres")
            false
        }
        else if (!PASSWORDPATTERN.matcher(password).matches() and !PASSWORDPATTERN.matcher(passwordConfirmation).matches()) {
            binding.contrasena.error = ("Contraseña debil, incluye al menos un caracter especial sin espacios")
            binding.confirmarContrasena.error = ("Contraseña debil, incluye al menos un caracter especial sin espacios")
            false
        }
        else {
            binding.contrasena.error = null
            binding.confirmarContrasena.error = null
            true
        }
    }


}