package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Riwayat_History_Transaksi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat_history_transaksi)

        // Jalankan fungsi navigasi bawah
        setupBottomNavigation()
    }

    // Menggunakan onResume agar setiap kali halaman dibuka, list langsung digambar otomatis
    override fun onResume() {
        super.onResume()
        tampilkanDaftarRiwayat()
    }

    private fun tampilkanDaftarRiwayat() {
        // 1. Siapkan Data Dummy Nota Transaksi Pasien
        val daftarRiwayat = listOf(
            ModelRiwayat("#TX-20260611-001", "Budi Santoso", "🕒 11 Juni, 09:15", "Rp 450.000", "Lunas"),
            ModelRiwayat("#TX-20260611-002", "Siti Aminah", "🕒 11 Juni, 10:30", "Rp 150.000", "Lunas"),
            ModelRiwayat("#TX-20260611-003", "Rian Hidayat", "🕒 11 Juni, 14:00", "Rp 280.000", "Lunas")
        )

        // 2. Pasang data ke RecyclerView Riwayat (SUDAH DIPERBAIKI)
        val rvRiwayat = findViewById<RecyclerView>(R.id.rvRiwayat)
        if (rvRiwayat != null) {
            rvRiwayat.layoutManager = LinearLayoutManager(this)

            // Perbaikan di baris ini: Panggil langsung nama Adapternya dan masukkan datanya
            rvRiwayat.adapter = RiwayatAdapter(daftarRiwayat)
        }
    }

    private fun setupBottomNavigation() {
        val menuDashboard = findViewById<LinearLayout>(R.id.menu_dashboard)
        val menuServices = findViewById<LinearLayout>(R.id.menu_services)
        val menuHistory = findViewById<LinearLayout>(R.id.menu_history)
        val menuReports = findViewById<LinearLayout>(R.id.menu_reports)

        menuHistory?.setOnClickListener {
            Toast.makeText(this, "Anda sudah berada di halaman Riwayat", Toast.LENGTH_SHORT).show()
        }

        menuServices?.setOnClickListener {
            val intent = Intent(this, KelolaLayananActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        menuDashboard?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }

        menuReports?.setOnClickListener {
            val intent = Intent(this, LaporanActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }
    }
}

// Wadah data transaksi (Model)
data class ModelRiwayat(
    val noTransaksi: String,
    val namaPasien: String,
    val tanggal: String,
    val totalHarga: String,
    val status: String
)