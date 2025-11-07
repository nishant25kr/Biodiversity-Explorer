package com.example.myapplication.model

data class Sighting(
    val speciesName: String,
    val type: String,
    val location: String,
    val date: String,
    val imageUri: String? = null
)
