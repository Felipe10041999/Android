package com.example.myapplication

class Persona (private var Nombre: String = "Felipe",
               private var Edad: Int = 25){
    fun Persona (nom: String, edad: Int){
        this.Nombre = nom
        this.Edad = edad
    }
    fun getNombre(): String{return this.Nombre}
    fun getEdad(): Int{return this.Edad}
}