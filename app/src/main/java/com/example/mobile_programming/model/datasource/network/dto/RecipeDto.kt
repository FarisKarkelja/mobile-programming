package com.example.mobile_programming.model.datasource.network.dto

data class RecipeDto(
    val id: Int,
    val name: String,
    val userId: Int,
    val imageUrl: String,
    val ingredients: String,
    val instructions: String,
    val cookingTime: String
)

data class CreateRecipeDto(
    val name: String,
    val userId: Int,
    val imageUrl: String,
    val ingredients: String,
    val instructions: String,
    val cookingTime: String
)

data class UpdateRecipeDto(
    val userId: Int? = null,
    val name: String? = null,
    val imageUrl: String? = null,
    val ingredients: String? = null,
    val instructions: String? = null,
    val cookingTime: String? = null
)