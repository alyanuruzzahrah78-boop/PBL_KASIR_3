package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Menampilkan layout utama dashboard
        setContentView(R.layout.dashboard_activity)

        // 2. Inisialisasi menu bawah sesuai ID XML
        val menuDashboard = findViewById<LinearLayout>(R.id.menu_dashboard)
        val menuServices = findViewById<LinearLayout>(R.id.menu_services)
        val menuHistory = findViewById<LinearLayout>(R.id.menu_history)
        val menuReports = findViewById<LinearLayout>(R.id.menu_reports)
        val btnlogout = findViewById<ImageView>(R.id.btnKeluarRole6)

        // 3. Logika klik masing-masing menu bawah
        menuDashboard?.setOnClickListener {
            // Sudah di dashboard, diamkan saja
        }

        menuServices?.setOnClickListener {
            val intent = Intent(this, KelolaLayananActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION) // Menghilangkan animasi kedip antar-menu bawah
            startActivity(intent)
            // Jangan gunakan finish() di sini agar user bisa menekan tombol back untuk kembali ke Dashboard
        }

        menuHistory?.setOnClickListener {
            val intent = Intent(this, Riwayat_History_Transaksi::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        menuReports?.setOnClickListener {
            val intent = Intent(this, LaporanActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        btnlogout?.setOnClickListener {
            // Mengarahkan balik ke halaman Login
            val intentLogin = Intent(this, LoginActivity::class.java)
            // Menghapus seluruh tumpukan halaman agar tidak bisa di-back ke dashboard setelah logout
            intentLogin.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentLogin)
            finish()
        }
    }
}