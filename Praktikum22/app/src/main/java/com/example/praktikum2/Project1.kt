package com.example.praktikum2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Project1 : AppCompatActivity() {
    lateinit var etNama: EditText
    lateinit var  NIM: EditText
    lateinit var Nilai: EditText
    lateinit var  textjudul: TextView
    lateinit var btProses: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_project1)

        etNama = findViewById<EditText>(R.id.etNama)
        NIM = findViewById<EditText>(R.id.NIM)
        Nilai =findViewById<EditText>(R.id.Nilai)
        textjudul = findViewById<TextView>(R.id.textjudul)
        btProses = findViewById<Button>(R.id.btProses)

        btProses.setOnClickListener {
            val nama = etNama.text.toString()
            val nim = NIM.text.toString()
            val nilaiStr = Nilai.text.toString()

            if (nama.isEmpty() || nim.isEmpty() || nilaiStr.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
        }

        val nilai = nilaiStr.toInt()

            val grade = when {
                nilai >= 85 -> "A"
                nilai >= 78 -> "B"
                nilai >= 60 -> "C"
                nilai >= 50 -> "D"
                 else -> "E"
            }

            val intent = Intent(this@Project1, hasil:: class.java)
            intent.putExtra("name", nama)
            intent.putExtra("nim", nim)
            intent.putExtra("nilai", nilai)
            intent.putExtra("grade", grade)

            startActivity(intent)



        }
    }
}