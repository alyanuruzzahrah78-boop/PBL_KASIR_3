package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simrskel3.DaftarRoleActivity
import com.example.simrskel3.R
import java.text.NumberFormat
import java.util.Locale
import kotlin.jvm.java

class KasirBayarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kasir_bayar)

        // 1. Tangkap semua data dari Tahap 2
        val idPasien = intent.getStringExtra("ID_PASIEN") ?: ""
        val namaPasien = intent.getStringExtra("NAMA_PASIEN") ?: ""
        val layanan = intent.getStringExtra("LAYANAN") ?: "Umum"
        val hargaString = intent.getStringExtra("HARGA") ?: "0"

        // Konversi harga ke angka untuk dihitung dengan admin (Rp 15.000)
        val hargaLayanan = hargaString.toInt()
        val biayaAdmin = 15000
        val totalHarga = hargaLayanan + biayaAdmin

        // 2. Inisialisasi UI
        val txtNotaPasien = findViewById<TextView>(R.id.txtNotaPasien)
        val txtNotaLayanan = findViewById<TextView>(R.id.txtNotaLayanan)
        val txtNotaHarga = findViewById<TextView>(R.id.txtNotaHarga)
        val txtNotaTotal = findViewById<TextView>(R.id.txtNotaTotal)
        val btnCetak = findViewById<Button>(R.id.btnCetak)
        val btnTutup = findViewById<Button>(R.id.btnTutup)

        // Format angka ke format Rupiah Indonesia
        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in", "ID"))

        // 3. Set data ke komponen Nota
        txtNotaPasien.text = "Pasien: An. $namaPasien ($idPasien)"
        txtNotaLayanan.text = layanan.split("(")[0].trim() // Mengambil nama layanannya saja
        txtNotaHarga.text = formatRupiah.format(hargaLayanan).replace("Rp", "Rp ")
        txtNotaTotal.text = formatRupiah.format(totalHarga).replace("Rp", "Rp ")

        // 4. Aksi Tombol Cetak Struk
        btnCetak.setOnClickListener {
            Toast.makeText(this, "Struk berhasil dicetak!", Toast.LENGTH_SHORT).show()
        }

        // 5. Aksi Tombol Tutup (Kembali ke halaman awal pilihan role admin/kasir)
        btnTutup.setOnClickListener {
            // Ganti 'DaftarRoleActivity' dengan nama file halaman pilihan role-mu
            val intentKeAwal = Intent(this, DaftarRoleActivity::class.java)

            // Bersihkan semua tumpukan halaman biar fresh kembali ke menu utama
            intentKeAwal.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intentKeAwal)
            finish()
        }
    }
}