package com.example.hospital

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hospital.model.Cita
import kotlinx.android.synthetic.main.item_cita.view.*

class CitasAdapter(private val citas: ArrayList<Cita>) : RecyclerView.Adapter<CitasAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNumCita = itemView.tvNumCita
        val tvDoctorName = itemView.tvDoctorName
        val tvDiaCita = itemView.tvDiaCita
        val tvHoraCita = itemView.tvHoraCita

        fun bind(cita: Cita){
            with (itemView){
                tvNumCita.text = itemView.context.getString(R.string.item_cita_id, cita.id)
                tvDoctorName.text = itemView.context.getString(R.string.item_cita_doctorName, cita.doctorName)
                tvDiaCita.text = itemView.context.getString(R.string.item_cita_diaCita, cita.diaCita)
                tvHoraCita.text = itemView.context.getString(R.string.item_cita_horaCita, cita.horaCita)
            }
        }
    }

    //Creamos la vista a partir del xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cita, parent, false)
        )
    }

    //Cantidad de elementos
    override fun getItemCount(): Int {
        return citas.size
    }

    //Enlaza la data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cita = citas[position]

        holder.bind(cita)
    }
}