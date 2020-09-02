package com.example.hospital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        Registro()
        volver()
    }

    //Registro
    private fun Registro(){
        btnConfirmarRegis.setOnClickListener{
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

            loginScreen()

        }
    }

    //Ya tienes cuenta?
    private fun volver() {
        goToLogin.setOnClickListener {
            loginScreen()
        }
    }

    //Volver al login
    private fun loginScreen(){
        val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
    }
}