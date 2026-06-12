package com.example.praktikum1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btproses_lat2 = findViewById<Button>(R.id.btproses_lat2)
        val txtnama_lat2 = findViewById<EditText>(R.id.txtnama_lat2)
        val txthasil_lat2 = findViewById<EditText>(R.id.txthasil_lat2)

        btproses_lat2.setOnClickListener {
            txthasil_lat2.text = txtnama_lat2.text
        }
    }
}