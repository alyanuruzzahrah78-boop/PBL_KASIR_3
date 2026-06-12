package com.example.praktikum1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Latihan4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan4)

        val etNama = findViewById<EditText>(R.id.et_nama)
        val hasil = findViewById<TextView>(R.id.tv_hasil_output)
        val btProses = findViewById<Button>(R.id.bt_proses)

        btProses.setOnClickListener {
            val strValue = etNama.text.toString()

            if (strValue.isNotEmpty()) {
                hasil.append("$strValue\n")
                etNama.text.clear()
            } else {
                etNama.error = "Tidak boleh kosong"
            }
        }

    }
}