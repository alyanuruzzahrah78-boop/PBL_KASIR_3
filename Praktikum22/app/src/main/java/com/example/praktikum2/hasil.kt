package com.example.praktikum2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.R

class hasil : AppCompatActivity() {zzzzzzz
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hasil)

        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvNim = findViewById<TextView>(R.id.tvNim)
        val tvNilai = findViewById<TextView>(R.id.tvNilai)
        val tvGrade = findViewById<TextView>(R.id.tvGrade)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}