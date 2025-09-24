package com.example.appinterface.Api

import com.example.appinterface.Usuarios.Usuario
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiServiceUsuario {
    @GET("/usuarios")
    fun getUsuarios(): Call<List<Usuario>>

    @POST("usuarios")
    fun postUsuarios(@Body usuario: Usuario): Call<ResponseBody>

    @PUT("usuarios/{id}")
    fun putUsuarios(@Path("id") id: Int, @Body usuario: Usuario): Call<String>

    @DELETE("usuarios/{id}")
    fun deleteUsuarios(@Path("id") id: Int): Call<Void>
}
