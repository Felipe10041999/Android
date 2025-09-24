package com.example.appinterface.Usuarios

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appinterface.Api.RetrofitInstance
import com.example.appinterface.R
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistroUsuario : AppCompatActivity() {

    private lateinit var numDoc : EditText
    private lateinit var nombres: EditText
    private lateinit var apellidos: EditText
    private lateinit var direccion :EditText
    private lateinit var email: EditText
    private lateinit var numTel: EditText
    private lateinit var fecNac: EditText
    private lateinit var password: EditText
    private lateinit var tipodocId: EditText
    private lateinit var rolId: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_usuario)

        numDoc = findViewById(R.id.numdoc)
        nombres = findViewById(R.id.nombres)
        apellidos = findViewById(R.id.apellidos)
        direccion = findViewById(R.id.direccion)
        email = findViewById(R.id.correo)
        numTel = findViewById(R.id.numTel)
        fecNac = findViewById(R.id.fecNac)
        password = findViewById(R.id.password)
        tipodocId = findViewById(R.id.tipodoc)
        rolId = findViewById(R.id.rolId)

        btnEnviar.setOnClickListener{
            val numDoc = numDoc.text.toString().trim()
            val nombres = nombres.text.toString().trim()
            val apellidos = apellidos.text.toString().trim()
            val direccion = direccion.text.toString().trim()
            val email = email.text.toString().trim()
            val numTel = numTel.text.toString().trim()
            val fecNac = fecNac.text.toString().trim()
            val password = password.text.toString().trim()
            val tipodocId = tipodocId.text.toString().toLong()
            val rolId = rolId.text.toString().toLong()

            if (numDoc.isEmpty() || nombres.isEmpty() || apellidos.isEmpty()||
                direccion.isEmpty()|| email.isEmpty()|| numTel.isEmpty()||fecNac.isEmpty()||
                password.isEmpty()||tipodocId.toString().isEmpty()||rolId.toString().isEmpty()){
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usuario = Usuario(
                numDoc = numDoc,
                nombres = nombres,
                apellidos = apellidos,
                direccion = direccion,
                email = email,
                numTel = numTel,
                fecNac = fecNac,
                password = password,
                tipodocId = tipodocId,
                rolId = rolId
            )
            val gson = Gson()
            Log.d("Json", gson.toJson(usuario))

            registroUsuario(usuario)
        }
    }
    private fun registroUsuario(usuario: Usuario){
        val call = RetrofitInstance.api3kotlin.postUsuarios(usuario)

        call.enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>){
                if (response.isSuccessful){
                    val responseText = response.body()?.string()?:"Sin mensaje"
                    Toast.makeText(this@RegistroUsuario, "Usuario registrado con exito: $responseText", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(this@RegistroUsuario, "Error al registrar el usuario", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable){
                Toast.makeText(this@RegistroUsuario, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}