package com.example.simrskel3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Dashboard : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mantra untuk menempelkan layout XML fragment_dashboard ke dalam fragment ini
        return inflater.inflate(R.layout.dashboard_activity, container, false)
    }
}