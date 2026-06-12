package com.example.simrskel3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RiwayatAdapter(private val listRiwayat: List<ModelRiwayat>) :
    RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>() {

    class RiwayatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNoTransaksi: TextView? = itemView.findViewById(R.id.txtNoTransaksi)
        val badgeStatusBayar: TextView? = itemView.findViewById(R.id.badgeStatusBayar)
        val txtNamaPasien: TextView? = itemView.findViewById(R.id.txtNamaPasien)
        val txtTanggal: TextView? = itemView.findViewById(R.id.txtTanggal)
        val txtTotalHarga: TextView? = itemView.findViewById(R.id.txtTotalHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RiwayatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_riwayat_history, parent, false)
        return RiwayatViewHolder(view)
    }

    override fun onBindViewHolder(holder: RiwayatViewHolder, position: Int) {
        val riwayat = listRiwayat[position]

        // Mengisi data secara aman
        holder.txtNoTransaksi?.text = riwayat.noTransaksi
        holder.badgeStatusBayar?.text = riwayat.status
        holder.txtNamaPasien?.text = riwayat.namaPasien
        holder.txtTanggal?.text = riwayat.tanggal
        holder.txtTotalHarga?.text = riwayat.totalHarga
    }

    override fun getItemCount(): Int {
        return listRiwayat.size
    }
}