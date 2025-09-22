package com.example.appinterface.Api

import com.example.appinterface.Usuario
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceUsuario {
    @GET("/usuarios")
    fun getUsuarios(): Call<List<Usuario>>
}
