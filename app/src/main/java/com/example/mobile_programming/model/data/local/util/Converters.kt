package com.example.mobile_programming.model.data.local.util

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromAllergensList(value: List<Allergens>?): String {
        return value?.joinToString(",") { it.name } ?: ""
    }

    @TypeConverter
    fun toAllergensList(value: String?): List<Allergens> {
        if (value.isNullOrBlank()) return emptyList()
        return value.split(",").mapNotNull {
            Allergens.entries.find { allergen -> allergen.name == it }
        }
    }
}