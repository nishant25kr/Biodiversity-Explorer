package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.Sighting
import com.example.myapplication.model.StorageHelper

class AddSightingActivity : AppCompatActivity() {

    private var selectedImageUri: Uri? = null
    private lateinit var previewImage: ImageView
    private lateinit var placeholderLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sighting)

        // Get all views
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val typeInput = findViewById<EditText>(R.id.typeInput)
        val locationInput = findViewById<EditText>(R.id.locationInput)
        val dateInput = findViewById<EditText>(R.id.dateInput)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val addPhotoButton = findViewById<Button>(R.id.addPhotoButton)
        previewImage = findViewById(R.id.previewImage)
        placeholderLayout = findViewById(R.id.placeholderLayout)

        // Register gallery picker
        val pickImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                selectedImageUri = result.data!!.data
                previewImage.setImageURI(selectedImageUri)
                previewImage.visibility = View.VISIBLE
                placeholderLayout.visibility = View.GONE
            }
        }

        // Open gallery when user taps photo button
        addPhotoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            pickImageLauncher.launch(intent)
        }

        // Save new sighting
        saveButton.setOnClickListener {
            val newSighting = Sighting(
                speciesName = nameInput.text.toString(),
                type = typeInput.text.toString(),
                location = locationInput.text.toString(),
                date = dateInput.text.toString(),
                imageUri = selectedImageUri?.toString() // Save URI as string
            )

            val currentSightings = StorageHelper.getSightings(this)
            currentSightings.add(newSighting)
            StorageHelper.saveSightings(this, currentSightings)

            Toast.makeText(this, "Sighting saved successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
