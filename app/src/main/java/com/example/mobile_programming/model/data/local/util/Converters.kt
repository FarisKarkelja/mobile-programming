package com.example.mobile_programming.model.data.local.util

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromAllergensList(value: List<ALLERGENS>?): String {
        return value?.joinToString(",") { it.name } ?: ""
    }

    @TypeConverter
    fun toAllergensList(value: String?): List<ALLERGENS> {
        if (value.isNullOrBlank()) return emptyList()
        return value.split(",").mapNotNull {
            try {
                ALLERGENS.valueOf(it)
            } catch (e: Exception) {
                null
            }
        }
    }
}