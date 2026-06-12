package com.example.praktikum1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan3)
        val bt_Proses = findViewById<Button>(R.id.bt_proses)
        val et_nama = findViewById<EditText>(R.id.et_nama)

        bt_proses.setOnClickListener {
            Toast.makeText(applicationContext, et_nama.text,Toast.LENGTH_SHORT).show()
        }
    }
}