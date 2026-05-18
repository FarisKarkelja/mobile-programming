package com.example.mobile_programming.model.datasource.network.mapper

import com.example.mobile_programming.model.datasource.network.dto.RecipeDto
import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe

fun RecipeDto.toDomain(): Recipe {
    return Recipe(
        id = this.id.toString(),
        name = this.name,
        userId = this.userId.toString(),
        imageUrl = this.imageUrl,
        ingredients = this.ingredients,
        instructions = this.instructions,
        cookingTime = this.cookingTime
    )
}