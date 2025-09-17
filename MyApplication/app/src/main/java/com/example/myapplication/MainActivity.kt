package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var persona: Persona
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun crearpersona(v: View){

        var nombre = findViewById<EditText>(R.id.nombre)
        var edad = findViewById<EditText>(R.id.edad)

        persona = Persona()

        if (!nombre.text.isNullOrEmpty() && !edad.text.isNullOrEmpty())
            persona.Persona(nombre.text.toString(), edad.text.toString().toInt())

        var ppersona = findViewById<TextView>(R.id.textView3)
        DataPersona(ppersona, persona)
    }

    private fun DataPersona(ppersona: TextView,persona:Persona){
        var description: String= ""
        description += "Nombre"+ persona.getNombre() +" "
        description += "Edad"+ persona.getEdad()

        ppersona.text = description
    }
}
