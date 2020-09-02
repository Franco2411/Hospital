package com.example.hospital

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shared()
        setup()
    }

    //setup
    private fun setup(){

        //Ir al Activity de registro
        btnRegistro.setOnClickListener{
            val registro = Intent(this, RegisterActivity::class.java)
            startActivity(registro)
            Toast.makeText(this, "Por favor completa tus datos.", Toast.LENGTH_SHORT).show()
        }

        //Ir al menu
        btnInicio.setOnClickListener{
            createSessionPreference()
            showActivity()
        }
    }

    private fun showActivity() {
        val menuIntent = Intent(this, MenuActivity::class.java)
        startActivity(menuIntent)
        finish()
    }

    //Guardado de datos
    private fun shared() {

        val prefs = getSharedPreferences("general", Context.MODE_PRIVATE)
        val session = prefs.getBoolean("session", false)


        if (session == true) {
            showActivity()
        }
    }

    private fun createSessionPreference() {

        val prefs = getSharedPreferences("general", Context.MODE_PRIVATE).edit()
        prefs.putBoolean("session", true)
        prefs.apply()
    }
}