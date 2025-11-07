package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySightingDetailBinding

class SightingDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySightingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySightingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val type = intent.getStringExtra("type")
        val location = intent.getStringExtra("location")
        val date = intent.getStringExtra("date")

        binding.nameText.text = name
        binding.typeText.text = type
        binding.locationText.text = location
        binding.dateText.text = date
    }
}
