package com.example.hospital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hospital.model.Cita
import kotlinx.android.synthetic.main.activity_mis_citas.*

class MisCitasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_citas)

        val citas = ArrayList<Cita>()
        citas.add(Cita(1, "Franco Allovero", "10/08/2020", "14:00"))
        citas.add(Cita(2, "Tomas", "15/08/2020", "17:00"))
        citas.add(Cita(3, "Fausto Bressa", "25/08/2020", "10:00"))

        rvCitas.layoutManager = LinearLayoutManager(this)
        rvCitas.adapter = CitasAdapter(citas)
    }
}