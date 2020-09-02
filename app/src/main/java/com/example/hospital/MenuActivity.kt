package com.example.hospital

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    private val snackBar by lazy {
        Snackbar.make(menuLayout, R.string.presione_again, Snackbar.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setup()
    }

    //Funcionalidad botones
    private fun setup(){

        //Cerrar sesión
        btnLogOut.setOnClickListener{
            clearSessionPreference()
            val loginIntent = Intent(this, MainActivity::class.java)
            startActivity(loginIntent)
            finish()
        }

        //Reservar cita
        btnRegistroCita.setOnClickListener{
            val reservaIntent = Intent(this, CreateAppointmentActivity::class.java)
            startActivity(reservaIntent)
        }

        //Mis citas
        btnMisCitas.setOnClickListener{
            val citasIntent = Intent(this, MisCitasActivity::class.java)
            startActivity(citasIntent)
        }

    }

    private fun clearSessionPreference() {

        val prefs = getSharedPreferences("general", Context.MODE_PRIVATE).edit()
        prefs.putBoolean("session", false)
        prefs.apply()
    }

    override fun onBackPressed() {

        if (snackBar.isShown) {
            super.onBackPressed()

        } else {
            snackBar.show()
        }
    }
}