package com.example.simrskel3

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // Sesuaikan "api/layanan" dengan endpoint yang dibuat oleh teman backend kalian
    @GET("backend/layanan")
    fun getDaftarLayanan(): Call<List<Layanan>>
}