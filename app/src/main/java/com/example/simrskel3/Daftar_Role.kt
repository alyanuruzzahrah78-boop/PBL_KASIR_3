package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DaftarRoleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_role)

        val btnAdminKasir = findViewById<CardView>(R.id.btnAdminKasir)

        // Logika ketika tombol Admin Kasir diklik
        btnAdminKasir.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup halaman Daftar Role agar tidak bisa di-back lagi
        }
    }
}