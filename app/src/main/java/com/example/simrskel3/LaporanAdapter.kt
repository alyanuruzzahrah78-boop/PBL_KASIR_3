package com.example.simrskel3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simrskel3.com.example.simrskel3.ModelLaporan

class LaporanAdapter(private val listLaporan: List<ModelLaporan>) :
    RecyclerView.Adapter<LaporanAdapter.LaporanViewHolder>() {

    class LaporanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNama: TextView = itemView.findViewById(R.id.txtNamaLayananLaporan)
        val txtTransaksi: TextView = itemView.findViewById(R.id.txtJumlahTransaksi)
        val txtNominal: TextView = itemView.findViewById(R.id.txtNominalLayanan)
        val imgIcon: ImageView = itemView.findViewById(R.id.imgIkonLayananLaporan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaporanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_laporan, parent, false)
        return LaporanViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaporanViewHolder, position: Int) {
        val data = listLaporan[position]
        holder.txtNama.text = data.txtNamaLayananLaporan
        holder.txtTransaksi.text = data.txtJumlahTransaksi
        holder.txtNominal.text = data.txtNominalLayanan
        holder.imgIcon.setImageResource(data.imgIkonLayananLaporan)
    }

    override fun getItemCount(): Int = listLaporan.size
}