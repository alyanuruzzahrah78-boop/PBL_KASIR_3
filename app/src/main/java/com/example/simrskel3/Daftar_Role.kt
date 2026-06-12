package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DaftarRoleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_role)

        val btnRoleAdmin = findViewById<CardView>(R.id.btnAdminKasir)
        val btnRoleKasir = findViewById<CardView>(R.id.btnKasirBiasa)

        // MASUK KE DASHBOARD ADMIN VIA MAINACTIVITY
        btnRoleAdmin?.setOnClickListener {
            val intentAdmin = Intent(this, MainActivity::class.java)
            startActivity(intentAdmin)
        }

        // MASUK KE HALAMAN KASIR PASIEN
        btnRoleKasir?.setOnClickListener {
            val intentKasir = Intent(this, KasirPasienActivity::class.java)
            startActivity(intentKasir)
        }
    }
}