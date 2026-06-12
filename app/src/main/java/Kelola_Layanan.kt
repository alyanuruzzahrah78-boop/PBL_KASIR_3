package com.example.simrskel3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.jvm.java

class KelolaLayananActivity : AppCompatActivity() {

    private lateinit var adapterLayanan: LayananAdapter
    private lateinit var daftarLayananAsli: List<Layanan.Layanan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelola_layanan)

        // 1. ISI DATA DUMMY (Sudah disesuaikan dengan model baru)
        daftarLayananAsli = listOf(
            Layanan.Layanan(
                1,
                "Konsultasi Umum",
                "Poli Umum • Reguler",
                150000,
                "Aktif",
                R.drawable.ic_poli_medical
            ),
            Layanan.Layanan(
                2,
                "Vaksinasi Influenza",
                "Poli Imunisasi • Paket",
                450000,
                "Aktif",
                R.drawable.ic_vaksin
            ),
            Layanan.Layanan(
                3,
                "Rontgen Dada (Thorax)",
                "Radiologi • Penunjang",
                280000,
                "Aktif",
                R.drawable.ic_rotgen
            ),
            Layanan.Layanan(
                4,
                "Cek Gula Darah",
                "Laboratorium • Rutin",
                750000,
                "Aktif",
                R.drawable.ic_biotech
            )
        )

        // 2. Jalankan RecyclerView (Sekarang aman karena data sudah terisi)
        aturRecyclerView(daftarLayananAsli)

        // 3. Logika Pencarian
        val kolomCari = findViewById<EditText>(R.id.searchLayanan)
        kolomCari?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saringData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        // 4. Logika Klik Tombol Tambah (+)
        val fabTambahLayanan = findViewById<FloatingActionButton>(R.id.fabTambahLayanan)
        fabTambahLayanan?.setOnClickListener {
            Toast.makeText(this, "Tambah layanan baru diklik!", Toast.LENGTH_SHORT).show()
        }

        // 5. Aktifkan Navigasi Bawah
        setupBottomNavigation()
    }

    private fun aturRecyclerView(list: List<Layanan.Layanan>) {
        val rvLayanan = findViewById<RecyclerView>(R.id.rvLayanan)
        if (rvLayanan != null) {
            rvLayanan.layoutManager = LinearLayoutManager(this)
            adapterLayanan = LayananAdapter(list)
            rvLayanan.adapter = adapterLayanan
        }
    }

    private fun saringData(teks: String) {
        val hasilSaring = daftarLayananAsli.filter { layanan ->
            layanan.namaLayanan.lowercase().contains(teks.lowercase()) ||
                    layanan.kategori.lowercase().contains(teks.lowercase())
        }
        if (::adapterLayanan.isInitialized) {
            adapterLayanan.perbaruiData(hasilSaring)
        }
    }

    private fun setupBottomNavigation() {
        val menuDashboard = findViewById<LinearLayout>(R.id.menu_dashboard)
        val menuServices = findViewById<LinearLayout>(R.id.menu_services)
        val menuHistory = findViewById<LinearLayout>(R.id.menu_history)
        val menuReports = findViewById<LinearLayout>(R.id.menu_reports)

        menuServices?.setOnClickListener {
            Toast.makeText(this, "Anda sudah berada di halaman Layanan", Toast.LENGTH_SHORT).show()
        }

        menuHistory?.setOnClickListener {
            val intent = Intent(this, Riwayat_History_Transaksi::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }

        menuDashboard?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }

        menuReports?.setOnClickListener {
            val intent = Intent(this, LaporanActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }
    }
}