package com.example.transportproyecto
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.example.transportproyecto.client.ApiClient
import com.example.transportproyecto.databinding.ActivityPerfilBinding
import com.example.transportproyecto.model.request.UserRequest
import com.example.transportproyecto.model.response.User
import com.example.transportproyecto.model.response.UserManager
import com.example.transportproyecto.model.response.UserResponse
import com.example.transportproyecto.service.ApiService
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("NAME_SHADOWING")
class Perfil : AppCompatActivity(), View.OnClickListener {

    var userData: User? = null

    private var userId = 0

    private lateinit var binding: ActivityPerfilBinding


    private lateinit var viewRoot: LinearLayout
    private lateinit var usuario: EditText
    private lateinit var email: EditText

    private lateinit var tvUser: TextView
    private lateinit var tvEmail: TextView


    @SuppressLint("SetTextI18n", "InflateParams")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        binding.uploadContent.setOnClickListener{
            startActivity(Intent(this, ContentPostActivity::class.java))
        }
        initData()
    }


    private fun initData() {
        userId = UserManager.getUserId()
        getUserPerfil(userId.toString())

        binding.BtneditarPerfil.setOnClickListener {
            dialog()
        }



        binding.BtneliminarCuenta.setOnClickListener {
            Toast.makeText(this@Perfil, "Perfil eliminado ", Toast.LENGTH_LONG).show()
        }
    }



    @SuppressLint("MissingInflatedId", "UseCompatLoadingForDrawables", "SuspiciousIndentation",
        "CutPasteId")

    private fun dialog(){
        val view = layoutInflater.inflate(R.layout.activity_editar_perfil, null)


        viewRoot = view.findViewById(R.id.viewRoot)
        usuario = view.findViewById(R.id.usuario)
        email = view.findViewById(R.id.email)

        tvUser = view.findViewById(R.id.tvUser)
        tvEmail= view.findViewById(R.id.tvEmail)

        userData?.let { user ->
            usuario.setText(user.usuario)
            email.setText(user.email)
        }

        val alertDialog = MaterialAlertDialogBuilder(this)
        alertDialog.setTitle(resources.getString(R.string.title))
        alertDialog.setPositiveButtonIcon(resources.getDrawable(R.drawable.enviar, theme))
        alertDialog.setView(view)
        val dialog: AlertDialog = alertDialog.create()
        dialog.show()//.setPositiveButtonIcon(resources.getDrawable(R.drawable.logo, theme))
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {

            if (validateEmail() and validateUserAndDate()){
                if (usuario.text.toString().isNotEmpty() && email.text.toString()
                    .isNotEmpty()) {
                    val userRequest = UserRequest(
                        usuario.text.toString(),
                        email.text.toString()
                    )
                    Toast.makeText(this@Perfil, "Perfil editado correctamente ", Toast.LENGTH_LONG).show()
                    updatePerfil(userRequest, userId.toString())
                    dialog.dismiss()
                } else {
                    validate()
                    Toast.makeText(this@Perfil, "Llene todos los campos", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


    private fun validate() {
        val result = arrayOf(validateEmail(), validateUserAndDate())
        if (false in result) {
            return
        }
    }



    @SuppressLint("SetTextI18n")

    private fun validateEmail(): Boolean {
        val email = email.text.toString()
        return if (email.isEmpty()) {
            tvEmail.text = "llene el campo de correo"
            false
        }
        else if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
            tvEmail.text = "ingresar un correo valido"
            false
        }else{
            tvEmail.text = null
            true
        }
    }



    @SuppressLint("SetTextI18n")

    private fun validateUserAndDate(): Boolean {
        val user = usuario.text.toString()
        return if (user.isEmpty()){
            tvUser.text = "El campo user no esta lleno"
            false
        } else{
            tvUser.text = null
            true
        }
    }



    /**
     *  Get data of User by id login
     */

    private fun getUserPerfil(userId: String) {
        val apiService = ApiClient.getApiService()

        val userPerfilCall: Call<User> = apiService.getUserPerfil(userId)
        userPerfilCall.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    userData = response.body()
                    userData?.let {
                        findViewById<TextView>(R.id.Usuario).text    = it.usuario
                        findViewById<TextView>(R.id.Correo).text      =it.email
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@Perfil, "error conexión ", Toast.LENGTH_LONG).show()
            }
        })

    }




    /**
     * Update user by id
     */
    private fun updatePerfil(userRequest: UserRequest, userId: String) {

        val apiService = ApiClient.getApiService()

        val userPerfilCall: Call<UserResponse> = apiService.updatePerfil(userRequest, userId)
        userPerfilCall.enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful)
                {
                    val user = response.body()
                    user?.let {
                        findViewById<TextView>(R.id.Usuario).text       = it.user
                        findViewById<TextView>(R.id.Correo).text        = it.email
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@Perfil, "Error ", Toast.LENGTH_LONG).show()
            }
        })
    }






    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}