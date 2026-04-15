package com.example.mobile_programming.presentation.ui.screens.restaurants.util

fun isWithinBudget(price: Double, budgetRange: String): Boolean {
    return when (budgetRange) {
        "Under 20 BAM" -> price < 20.0
        "20 - 50 BAM" -> price in 20.0..50.0
        "50 - 100 BAM" -> price in 50.0..100.0
        "100+ BAM" -> price > 100.0
        else -> true
    }
}