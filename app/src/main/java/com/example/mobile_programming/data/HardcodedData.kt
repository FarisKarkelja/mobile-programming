package com.example.mobile_programming.data

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.FoodDish
import com.example.mobile_programming.R

object HardcodedData {
    val restaurants = listOf(
        Restaurant(
            id = "1",
            name = "Trattoria Romana",
            cuisine = "Italian Cuisine",
            description = "Authentic Italian restaurant offering a variety of traditional dishes made with fresh, locally sourced ingredients.",
            imageResId = R.drawable.restaurant_placeholder,
            location = "Downtown",
            rating = 4.8,
            isFavorite = false,
            topDishes = listOf(
                FoodDish("Pasta", R.drawable.meal_1),
                FoodDish("Salad", R.drawable.meal_2),
                FoodDish("Tortilla", R.drawable.meal_3),
                FoodDish("Risotto", R.drawable.meal_4),
                FoodDish("Taco", R.drawable.meal_5),
                FoodDish("Pizza", R.drawable.meal_6)
            )
        ),
        Restaurant(
            id = "2",
            name = "Sushi Master",
            cuisine = "Japanese Cuisine",
            description = "Premium sushi and sashimi prepared by expert chefs.",
            imageResId = R.drawable.restaurant_placeholder,
            location = "Uptown",
            rating = 4.9,
            isFavorite = true,
            topDishes = emptyList()
        )
    )
}