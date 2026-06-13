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
        }

        // MASUK KE HALAMAN KASIR PASIEN
        btnRoleKasir?.setOnClickListener {
            val intentKasir = Intent(this, KasirPasienActivity::class.java)
            startActivity(intentKasir)
        }

        btnKeluar?.setOnClickListener {
            // Ganti 'LoginActivity' dengan nama file Activity Login kamu yang sebenarnya ya!
            val intentLogin = Intent(this, LoginActivity::class.java)

            // Tambahkan flags ini agar tumpukan halaman sebelumnya terhapus bersih
            intentLogin.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intentLogin)
            finish()
        }
    }
}