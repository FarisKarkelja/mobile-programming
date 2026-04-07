package com.example.mobile_programming.data

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.FoodDish
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category

object HardcodedData {
    val locations = listOf(
        "Location", "Dobrinja", "Nedžarići", "Alipašino Polje", "Otoka",
        "Čengić Vila", "Malta", "Pofalići", "Marijin Dvor",
        "Skenderija", "Baščaršija", "Vijećnica"
    )
    val budgets = listOf("Budget", "Under 20 BAM", "20 - 50 BAM", "50 - 100 BAM", "100+ BAM")

    val categories = listOf(
        Category(
            id = "1",
            name = "Local",
            iconResId = R.drawable.bosnia
        ),
        Category(
            id = "2",
            name = "Quick",
            iconResId = R.drawable.kebab
        ),
        Category(
            id = "3",
            name = "BBQ",
            iconResId = R.drawable.steak
        ),
        Category(
            id = "4",
            name = "Pie",
            iconResId = R.drawable.pie
        ),
        Category(
            id = "5",
            name = "Healthy",
            iconResId = R.drawable.salad
        ),
        Category(
            id = "6",
            name = "Global",
            iconResId = R.drawable.worldwide
        ),
        Category(
            id = "7",
            name = "Sweets",
            iconResId = R.drawable.cake
        ),
    )

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
            description = "Premium sushi and sashimi prepared by expert chefs in a modern, relaxing atmosphere.",
            imageResId = R.drawable.restaurant_placeholder_2,
            location = "Uptown",
            rating = 4.9,
            isFavorite = true,
            topDishes = emptyList()
        ),
        Restaurant(
            id = "3",
            name = "El Mariachi",
            cuisine = "Mexican Cuisine",
            description = "Spicy, vibrant, and delicious! Come enjoy the best tacos and margaritas in town.",
            imageResId = R.drawable.restaurant_placeholder_3,
            location = "City Center",
            rating = 4.5,
            isFavorite = true,
            topDishes = listOf(
                FoodDish("Taco", R.drawable.meal_5),
                FoodDish("Tortilla", R.drawable.meal_3)
            )
        ),
        Restaurant(
            id = "4",
            name = "Burger Joint",
            cuisine = "American Fast Food",
            description = "Classic smash burgers, crispy fries, and thick milkshakes. Perfect for a cheat meal.",
            imageResId = R.drawable.restaurant_placeholder_4,
            location = "Westside",
            rating = 4.2,
            isFavorite = false,
            topDishes = listOf(
                FoodDish("Pizza", R.drawable.meal_6),
                FoodDish("Salad", R.drawable.meal_2),
                FoodDish("Taco", R.drawable.meal_5)
            )
        ),
        Restaurant(
            id = "5",
            name = "Wok 'n' Roll",
            cuisine = "Chinese Street Food",
            description = "Fast, fresh, and piping hot wok dishes customized to your taste.",
            imageResId = R.drawable.restaurant_placeholder_5,
            location = "East End",
            rating = 4.6,
            isFavorite = true,
            topDishes = listOf(
                FoodDish("Risotto", R.drawable.meal_4),
                FoodDish("Salad", R.drawable.meal_2)
            )
        ),
        Restaurant(
            id = "6",
            name = "Le Petit Paris",
            cuisine = "French Cuisine",
            description = "Experience fine dining with our exquisite French menu and carefully selected wine pairings.",
            imageResId = R.drawable.restaurant_placeholder_6,
            location = "Riverside",
            rating = 4.7,
            isFavorite = false,
            topDishes = emptyList()
        ),
        Restaurant(
            id = "7",
            name = "Sarajevo Grill",
            cuisine = "Traditional BBQ",
            description = "Best local cevapi and grilled meat in the region. A must-visit for meat lovers.",
            imageResId = R.drawable.restaurant_placeholder_2,
            location = "Old Town",
            rating = 4.9,
            isFavorite = true,
            topDishes = listOf(
                FoodDish("Meat Plate", R.drawable.meal_1),
                FoodDish("Fresh Salad", R.drawable.meal_2),
                FoodDish("Bread", R.drawable.meal_3),
                FoodDish("Dessert", R.drawable.meal_4)
            )
        ),
        Restaurant(
            id = "8",
            name = "The Green Bowl",
            cuisine = "Vegan & Healthy",
            description = "100% plant-based restaurant focusing on organic ingredients and superfoods.",
            imageResId = R.drawable.restaurant_placeholder_3,
            location = "North Park",
            rating = 4.3,
            isFavorite = false,
            topDishes = listOf(
                FoodDish("Green Salad", R.drawable.meal_2),
                FoodDish("Vegan Taco", R.drawable.meal_5)
            )
        ),
        Restaurant(
            id = "9",
            name = "Taj Mahal",
            cuisine = "Indian Cuisine",
            description = "Rich, flavorful curries and fresh tandoori bread baked in a traditional clay oven.",
            imageResId = R.drawable.restaurant_placeholder_4,
            location = "Downtown",
            rating = 4.8,
            isFavorite = true,
            topDishes = listOf(
                FoodDish("Curry Bowl", R.drawable.meal_4),
                FoodDish("Naan", R.drawable.meal_3),
                FoodDish("Spicy Salad", R.drawable.meal_2)
            )
        ),
        Restaurant(
            id = "10",
            name = "Prime Cuts",
            cuisine = "Steakhouse",
            description = "Premium aged steaks cooked to perfection over an open wood fire grill.",
            imageResId = R.drawable.restaurant_placeholder_5,
            location = "Financial District",
            rating = 4.4,
            isFavorite = false,
            topDishes = listOf(
                FoodDish("Ribeye", R.drawable.meal_1),
                FoodDish("Caesar Salad", R.drawable.meal_2),
                FoodDish("Risotto Side", R.drawable.meal_4),
                FoodDish("Pizza Bread", R.drawable.meal_6)
            )
        )
    )
}