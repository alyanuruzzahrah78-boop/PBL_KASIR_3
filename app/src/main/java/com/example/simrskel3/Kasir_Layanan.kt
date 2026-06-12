package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simrskel3.R
import kotlin.jvm.java

class KasirLayananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kasir_layanan)

        // 1. Tangkap data dari Tahap 1 (KasirPasienActivity)
        val idPasien = intent.getStringExtra("ID_PASIEN") ?: "-"
        val namaPasien = intent.getStringExtra("NAMA_PASIEN") ?: "-"

        // 2. Inisialisasi Komponen UI
        val txtHeaderId = findViewById<TextView>(R.id.txtHeaderIdPasien)
        val txtHeaderNama = findViewById<TextView>(R.id.txtHeaderNamaPasien)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnKePembayaran = findViewById<Button>(R.id.btnKePembayaran)
        val rgLayanan = findViewById<RadioGroup>(R.id.rgLayanan)

        // Set teks header berdasarkan data pasien yang dioper
        txtHeaderId.text = "PATIENT ID: $idPasien"
        txtHeaderNama.text = namaPasien

        // 3. Tombol Back (Kembali ke verifikasi data pasien)
        btnBack.setOnClickListener {
            finish() // Tinggal difinish agar otomatis kembali ke halaman sebelumnya
        }

        // 4. Tombol Lanjut ke Pembayaran (Oper Semua Data ke Tahap 3)
        btnKePembayaran.setOnClickListener {
            val selectedId = rgLayanan.checkedRadioButtonId

            if (selectedId == -1) {
                // Jika kasir belum memilih tindakan medis sama sekali
                Toast.makeText(this, "Silakan pilih layanan terlebih dahulu!", Toast.LENGTH_SHORT).show()
            } else {
                val radioButton = findViewById<RadioButton>(selectedId)
                val layananTerpilih = radioButton.text.toString()

                // Tentukan harga tiruan berdasarkan layanan yang dipilih untuk nota di tahap 3
                val hargaLayanan = when (selectedId) {
                    R.id.rbLayanan1 -> "150000"
                    R.id.rbLayanan2 -> "250000"
                    R.id.rbLayanan3 -> "400000"
                    else -> "0"
                }

                // Intent menuju Tahap 3 (KasirBayarActivity)
                val intentToBayar = Intent(this, KasirBayarActivity::class.java)
                intentToBayar.putExtra("ID_PASIEN", idPasien)
                intentToBayar.putExtra("NAMA_PASIEN", namaPasien)
                intentToBayar.putExtra("LAYANAN", layananTerpilih)
                intentToBayar.putExtra("HARGA", hargaLayanan)
                startActivity(intentToBayar)
            }
        }
    }
}