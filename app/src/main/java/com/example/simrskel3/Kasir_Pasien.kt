package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simrskel3.DaftarRoleActivity
import com.example.simrskel3.R
import kotlin.jvm.java

class KasirPasienActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kasir_pasien)

        // 1. Inisialisasi Komponen UI dari XML
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val cbValidasi = findViewById<CheckBox>(R.id.cbValidasi)
        val btnSelanjutnya = findViewById<Button>(R.id.btnSelanjutnya)

        // 2. Logika Awal: Tombol Selanjutnya dimatikan dulu sebelum dicentang
        btnSelanjutnya.isEnabled = false
        btnSelanjutnya.alpha = 0.5f // Membuat tombol agak transparan tanda belum aktif

        // 3. Logika Checkbox (Mendengarkan perubahan centang)
        cbValidasi.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                btnSelanjutnya.isEnabled = true
                btnSelanjutnya.alpha = 1.0f // Tombol kembali terang & bisa diklik
            } else {
                btnSelanjutnya.isEnabled = false
                btnSelanjutnya.alpha = 0.5f
            }
        }

        // 4. Logika Tombol Back (Kembali ke Daftar Role)
        btnBack?.setOnClickListener {
            // Gantilah 'DaftarRoleActivity' dengan nama Class halaman daftar role-mu yang sebenarnya
            val intent = Intent(this, DaftarRoleActivity::class.java)
            startActivity(intent)
            finish() // Menutup halaman kasir agar tidak menumpuk di background
        }

        // 5. Logika Tombol Selanjutnya (Oper Data ke Tahap 2)
        btnSelanjutnya.setOnClickListener {
           val intent = Intent(this, KasirLayananActivity::class.java)

            // Titipkan data statis pasien dari halaman ini untuk dibawa ke halaman berikutnya
            intent.putExtra("ID_PASIEN", "RD-2024-B891")
            intent.putExtra("NAMA_PASIEN", "Budi Santoso")

            startActivity(intent)
        }
    }
}