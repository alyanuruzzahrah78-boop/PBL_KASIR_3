package com.example.simrskel3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class LayananAdapter(private var listLayanan: List<Layanan.Layanan>) :
    RecyclerView.Adapter<LayananAdapter.LayananViewHolder>() {

    class LayananViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNamaLayanan: TextView = itemView.findViewById(R.id.txtNamaLayanan)
        val txtKategori: TextView = itemView.findViewById(R.id.txtKategoriLayanan)
        val txtHarga: TextView = itemView.findViewById(R.id.txtHargaLayanan)
        val badgeStatus: TextView = itemView.findViewById(R.id.badgeStatus)
        val tombolPilihan: ImageView = itemView.findViewById(R.id.tombolPilihan)
        val imgIkonLayanan: ImageView = itemView.findViewById(R.id.img_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayananViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layanan, parent, false)
        return LayananViewHolder(view)
    }

    override fun onBindViewHolder(holder: LayananViewHolder, position: Int) {
        val layanan = listLayanan[position]

        holder.txtNamaLayanan.text = layanan.namaLayanan
        holder.txtKategori.text = layanan.kategori
        holder.badgeStatus.text = layanan.status

        // 🟢 FIX FORMAT UANG: Dipaksa ke String lewat format rupiah agar tidak memicu silent crash!
        try {
            val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
            holder.txtHarga.text = formatRupiah.format(layanan.harga).replace("Rp", "Rp ")
        } catch (e: Exception) {
            holder.txtHarga.text = "Rp ${layanan.harga.toString()}"
        }

        // Pasang gambar ikon secara dinamis
        holder.imgIkonLayanan.setImageResource(layanan.ikonGambar)

        holder.tombolPilihan.setOnClickListener { view ->
            val popup = PopupMenu(view.context, view)
            popup.menu.add(0, 1, 0, "Ubah Layanan")
            popup.menu.add(0, 2, 1, "Hapus Layanan")
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    1 -> {
                        Toast.makeText(view.context, "Mengubah: ${layanan.namaLayanan}", Toast.LENGTH_SHORT).show()
                        true
                    }
                    2 -> {
                        Toast.makeText(view.context, "Menghapus: ${layanan.namaLayanan}", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    override fun getItemCount(): Int {
        return listLayanan.size
    }

    fun perbaruiData(listBaru: List<Layanan.Layanan>) {
        this.listLayanan = listBaru
        notifyDataSetChanged()
    }
}