package com.example.myapplication.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object StorageHelper {
    private const val PREF_NAME = "sightings_pref"
    private const val KEY_SIGHTINGS = "sightings_list"

    fun saveSightings(context: Context, list: List<Sighting>) {
        val json = Gson().toJson(list)
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_SIGHTINGS, json)
            .apply()
    }

    fun getSightings(context: Context): MutableList<Sighting> {
        val json = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            .getString(KEY_SIGHTINGS, null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<Sighting>>() {}.type
            Gson().fromJson(json, type)
        } else mutableListOf()
    }
}
