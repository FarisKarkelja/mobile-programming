package com.example.mobile_programming.presentation.ui.screens.recipes.util

data class Recipe(
    val id: String,
    val name: String,
    val userId: String,
    val ingredients: String,
    val instructions: String,
    val cookingTime: String
)