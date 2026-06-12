package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Menampilkan layout utama dashboard
        setContentView(R.layout.dashboard_activity)

        // 2. Inisialisasi menu bawah sesuai ID XML kamu yang baru
        val menuDashboard = findViewById<LinearLayout>(R.id.menu_dashboard)
        val menuServices = findViewById<LinearLayout>(R.id.menu_services)
        val menuHistory = findViewById<LinearLayout>(R.id.menu_history)
        val menuReports = findViewById<LinearLayout>(R.id.menu_reports)

        // 3. Logika klik masing-masing menu bawah
        menuDashboard?.setOnClickListener {
            // Sudah di dashboard, diamkan saja
        }

        menuServices?.setOnClickListener {
            val intent = Intent(this, KelolaLayananActivity::class.java)
            startActivity(intent)
        }

        menuHistory?.setOnClickListener {
            val intent = Intent(this, Riwayat_History_Transaksi::class.java)
            startActivity(intent)
        }

        menuReports?.setOnClickListener {
            val intent = Intent(this, LaporanActivity::class.java)
            startActivity(intent)
        }
    }
}