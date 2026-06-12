package com.example.simrskel3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Kita langsung pasang layout XML-nya di sini
        setContentView(R.layout.dashboard_activity)
    }
}