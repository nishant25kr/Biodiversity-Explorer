package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Sighting
import com.example.myapplication.model.StorageHelper

class AddSightingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sighting)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val typeInput = findViewById<EditText>(R.id.typeInput)
        val locationInput = findViewById<EditText>(R.id.locationInput)
        val dateInput = findViewById<EditText>(R.id.dateInput)
        val saveBtn = findViewById<Button>(R.id.saveButton)

        saveBtn.setOnClickListener {
            val sighting = Sighting(
                nameInput.text.toString(),
                typeInput.text.toString(),
                locationInput.text.toString(),
                dateInput.text.toString(),
                R.drawable.ic_launcher_foreground
            )

            val list = StorageHelper.getSightings(this)
            list.add(sighting)
            StorageHelper.saveSightings(this, list)

            finish()
        }
    }
}
