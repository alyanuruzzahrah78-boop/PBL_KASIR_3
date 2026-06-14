package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class DaftarRoleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_role)

        val btnRoleAdmin = findViewById<CardView>(R.id.btnAdminKasir)
        val btnRoleKasir = findViewById<CardView>(R.id.btnKasirBiasa)
        val btnKeluar = findViewById<Button>(R.id.btnKeluar)

        // MASUK KE DASHBOARD ADMIN VIA MAINACTIVITY
        btnRoleAdmin?.setOnClickListener {
            val intentAdmin = Intent(this, MainActivity::class.java)
            startActivity(intentAdmin)
            finish() // 🟢 TAMBAHKAN INI KAK, biar halaman Daftar Role-nya mati dan ga ngumpet lagi!
        }

        // MASUK KE HALAMAN KASIR PASIEN
        btnRoleKasir?.setOnClickListener {
            val intentKasir = Intent(this, KasirPasienActivity::class.java)
            startActivity(intentKasir)
            finish() // 🟢 TAMBAHKAN INI JUGA biar adil dan aman!
        }

        btnKeluar?.setOnClickListener {
            val intentLogin = Intent(this, LoginActivity::class.java)
            intentLogin.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentLogin)
            finish()
        }
    }
}