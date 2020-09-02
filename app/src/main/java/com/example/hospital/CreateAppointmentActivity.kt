package com.example.hospital

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_appointment.*
import java.util.*

class CreateAppointmentActivity : AppCompatActivity() {

    private val calendario = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_appointment)

        //Carga de spinners
        horaSpin()

        setup()
    }


    //Spinners hora cita.
    private fun horaSpin(){

        //Especialidades
        val especialidades = arrayOf("Pediatría", "Oftalmología", "Psicología")
        spinnerEspe.adapter = ArrayAdapter<String>(this, R.layout.spinner_cardviews, especialidades)

        //Médicos
        val medicos = arrayOf("Doctor1", "Doctor2", "Doctor3")
        spinnerMedico.adapter = ArrayAdapter<String>(this, R.layout.spinner_cardviews, medicos)
    }

    //Botones
    private fun setup(){

        //Botón Next
        btnNext.setOnClickListener{
            card1.visibility = View.GONE
            card2.visibility = View.VISIBLE
        }

        //Botón Confirmar registro
        btnConfirmRegistro.setOnClickListener{
            Toast.makeText(this, "Cita reservada exitosamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        //Fecha cita
        txtFechaCita.setOnClickListener{
            val year = calendario.get(Calendar.YEAR)
            val month = calendario.get(Calendar.MONTH)
            val dayOfMonth = calendario.get(Calendar.DAY_OF_MONTH)

            val listener = DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->
                calendario.set(y, m, d)
                txtFechaCita.setText(resources.getString(R.string.date_format, d, m, y))
                displayRadioButtons()
            }


            val datePickerDialog = DatePickerDialog(this, listener, year, month, dayOfMonth)
            val datePicker = datePickerDialog.datePicker

            val calendario2 = Calendar.getInstance()
            calendario2.add(Calendar.DAY_OF_MONTH, 1)
            datePicker.minDate = calendario2.timeInMillis // +1
            calendario2.add(Calendar.DAY_OF_MONTH, 29)
            datePicker.maxDate = calendario2.timeInMillis //+30
            datePickerDialog.show()
        }
    }

    //Radio buttons dinámicos
    private fun displayRadioButtons(){
        radioGroup.clearCheck()
        radioGroup.removeAllViews()
        val horas = arrayOf("03:00 PM", "03:30 PM", "04:00 PM", "04:30 PM")

        horas.forEach{
            val radioButton = RadioButton(this)
            radioButton.id = View.generateViewId()
            radioButton.text = it
            radioGroup.addView(radioButton)
        }

        radioGroup.checkedRadioButtonId


    }

}