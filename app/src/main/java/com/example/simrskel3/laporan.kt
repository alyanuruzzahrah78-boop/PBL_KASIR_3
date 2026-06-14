package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.simrskel3.com.example.simrskel3.ModelLaporan

class LaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        // 1. Inisialisasi Data Dummy Sesuai Gambar Mockup
        val dataPendapatan = listOf(
            ModelLaporan("Instalasi Gawat Darurat", "14 Transaksi", "Rp 12.4M", R.drawable.ic_emergency),
            ModelLaporan("Poliklinik Spesialis", "32 Transaksi", "Rp 18.2M", R.drawable.ic_vaksin),
            ModelLaporan("Laboratorium", "45 Transaksi", "Rp 9.1M", R.drawable.ic_biotech),
            ModelLaporan("Farmasi", "58 Transaksi", "Rp 3.1M", R.drawable.ic_farmacy)
        )

        // 2. Pasang Data ke RecyclerView
        val rvLaporan = findViewById<RecyclerView>(R.id.rvLaporanLayanan)
        if (rvLaporan != null) {
            rvLaporan.adapter = LaporanAdapter(dataPendapatan)
        }

        // 3. Logika Tombol Download PDF
        val btnDownloadPdf = findViewById<Button>(R.id.btnDownloadPdf)
        btnDownloadPdf?.setOnClickListener {
            Toast.makeText(this, "Mengunduh Laporan PDF...", Toast.LENGTH_SHORT).show()
        }

        // 4. Aktifkan Navigasi Tombol Bawah
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val menuDashboard = findViewById<LinearLayout>(R.id.menu_dashboard)
        val menuServices = findViewById<LinearLayout>(R.id.menu_services)
        val menuHistory = findViewById<LinearLayout>(R.id.menu_history)
        val menuReports = findViewById<LinearLayout>(R.id.menu_reports)

        menuReports?.setOnClickListener {
            Toast.makeText(this, "Anda sudah berada di halaman Laporan", Toast.LENGTH_SHORT).show()
        }

        menuHistory?.setOnClickListener {
            val intent = Intent(this, Riwayat_History_Transaksi::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
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

        findViewById<ImageView>(R.id.btnKeluarRole3)?.setOnClickListener {
            val intent = Intent(this, DaftarRoleActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}