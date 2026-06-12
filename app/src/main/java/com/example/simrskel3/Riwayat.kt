package com.example.simrskel3.com.example.simrskel3

data class Riwayat(
    val noTransaksi: String,
    val namaPasien: String,
    val tanggal: String,
    val totalHarga: String,
    val statusBayar: String // Nanti isinya bisa "Lunas" atau "Tertunda"
)