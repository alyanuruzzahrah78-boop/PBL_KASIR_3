package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Ini tugas pertama: Menampilkan layout Dashboard Utama kalian
        setContentView(R.layout.activity_main)

        // 2. Ini tugas kedua: Menghubungkan tombol menu layanan bawah
        val btnMenuServices = findViewById<LinearLayout>(R.id.menu_services)

        // 3. Logika klik: Kalau menu layanan diklik, langsung buka halaman layanan
        btnMenuServices.setOnClickListener {
            val intent = Intent(this, KelolaLayananActivity::class.java)
            startActivity(intent)


        }
    }
}