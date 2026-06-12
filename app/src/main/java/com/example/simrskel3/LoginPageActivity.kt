package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page ) // ⚠️ Sesuaikan dengan nama file XML login kalian

        // 1. Hubungkan variabel Kotlin dengan komponen di XML (Find View By ID)
        val etinput = findViewById<EditText>(R.id.et_input)
        val etpassword = findViewById<EditText>(R.id.et_password)
        val btnmasuk = findViewById<Button>(R.id.btn_masuk)

        // 2. Berikan aksi ketika tombol MASUK diklik
        btnmasuk.setOnClickListener {
            // Ambil teks yang diketik oleh user
            val nik = etinput.text.toString().trim()
            val password = etpassword.text.toString().trim()

            // 3. Logika Validasi Sederhana (Tanpa API Dulu)
            if (nik.isEmpty() || password.isEmpty()) {
                // Munculkan peringatan kalau ada kotak yang kosong
                Toast.makeText(this, "NIK dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                // Jika sudah diisi (bebas isinya apa saja dulu untuk sementara)
                Toast.makeText(this, "Login Sukses!", Toast.LENGTH_SHORT).show()

                // Pindah halaman dari Login ke Kelola Layanan
                val intent = Intent(this, DaftarRoleActivity::class.java)
                startActivity(intent)

                finish() // Tutup halaman login agar tidak bisa di-back lagi
            }
        }
    }
}