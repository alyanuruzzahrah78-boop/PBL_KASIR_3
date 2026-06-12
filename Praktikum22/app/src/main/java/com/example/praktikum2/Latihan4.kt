package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etJumlahBebek = findViewById<EditText>(R.id.etJumlahBebek)
        val btnProsesBebek = findViewById<Button>(R.id.btnProsesBebek)
        val etJumlahBebek = findViewById<LinearLayout>(R.id.etJumlahBebek)

        btnProsesBebek.setOnClickListener {
            val input = etJumlahBebek.text.toString().toIntOrNull() ?: 0
            val jumlahBebek = input.coerceIn(1,6)
            LinearLayout.removeAllView()

            for (i in 1 < jumlahBebek) {
                val imageBebek = ImageView(context= this)
                imageBebek.SetImageResource(R.drawable.ic_bebek.xml)

                val params = LinearLayout.LayoutParams(width=150, height= 150)
                params.setMargins(left= 5, top= 5, right= 5, bottom= 5)
                imageBebek.layoutparams = params

                linearlayoutBebek.addView(child= imageBebek)
            }
        }
    }
}