package com.example.mobile_programming.model.datasource.network.mapper

import com.example.mobile_programming.model.datasource.network.dto.CreateRecipeDto
import com.example.mobile_programming.model.datasource.network.dto.RecipeDto
import com.example.mobile_programming.model.datasource.network.dto.UpdateRecipeDto
import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe

fun RecipeDto.toDomain(): Recipe {
    return Recipe(
        id = this.id.toString(),
        name = this.name,
        userId = this.userId.toString(),
        ingredients = this.ingredients,
        instructions = this.instructions,
        cookingTime = this.cookingTime
    )
}

fun mapToCreateRecipeDto(
    name: String,
    userId: Int,
    ingredients: String,
    instructions: String,
    cookingTime: String
): CreateRecipeDto {
    return CreateRecipeDto(name, userId, ingredients, instructions, cookingTime)
}

fun mapToUpdateRecipeDto(
    name: String,
    userId: Int,
    ingredients: String,
    instructions: String,
    cookingTime: String
): UpdateRecipeDto {
    return UpdateRecipeDto(userId, name, ingredients, instructions, cookingTime)
}