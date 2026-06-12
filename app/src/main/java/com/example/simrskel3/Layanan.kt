package com.example.simrskel3
import com.google.gson.annotations.SerializedName

class Layanan {
    data class Layanan(
        @SerializedName("id")
        val id: Int,

        @SerializedName("nama_layanan")
        val namaLayanan: String,

        @SerializedName("kategori")
        val kategori: String,

        @SerializedName("harga")
        val harga: Long,

        @SerializedName("status")
        val status: String,

        @SerializedName("ikonGambardariLayanan")
        val ikonGambar: Int
    )
}