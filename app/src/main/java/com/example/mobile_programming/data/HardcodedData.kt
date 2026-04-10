package com.example.mobile_programming.data

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.FoodDish
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.profile.util.User
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.util.Drink

object HardcodedData {
    val locations = listOf(
        "Location", "Dobrinja", "Nedžarići", "Alipašino Polje", "Otoka",
        "Čengić Vila", "Malta", "Pofalići", "Marijin Dvor",
        "Skenderija", "Baščaršija", "Vijećnica"
    )
    val budgets = listOf("Budget", "Under 20 BAM", "20 - 50 BAM", "50 - 100 BAM", "100+ BAM")

    val users = listOf(
        User(
            id = "1",
            fullName = "John Doe",
            email = "john.doe@example.com",
            password = "SuperSecretPassword!!123"
        ),
        User(
            id = "2",
            fullName = "Alice Johnson",
            email = "alice.johnson@example.com",
            password = "pass321"
        )
    )
    val categories = listOf(
        Category(
            id = "1",
            name = "Local",
            iconResId = R.drawable.category_1
        ),
        Category(
            id = "2",
            name = "Quick",
            iconResId = R.drawable.category_2
        ),
        Category(
            id = "3",
            name = "BBQ",
            iconResId = R.drawable.category_3
        ),
        Category(
            id = "4",
            name = "Pie",
            iconResId = R.drawable.category_4
        ),
        Category(
            id = "5",
            name = "Healthy",
            iconResId = R.drawable.category_5
        ),
        Category(
            id = "6",
            name = "Global",
            iconResId = R.drawable.category_6
        ),
        Category(
            id = "7",
            name = "Sweets",
            iconResId = R.drawable.category_7
        ),
    )

    val restaurants = listOf(
        Restaurant(
            id = "1",
            name = "Inat Kuća",
            cuisine = "Bosanska Kuhinja",
            categoryId = "7",
            description = "Authentic Italian restaurant offering a variety of traditional dishes made with fresh, locally sourced ingredients.",
            imageResId = R.drawable.restaurant_placeholder,
            location = "Baščaršija",
            address = "Veliki Alifakovac 1",
            avgPrice = 28.5,
            rating = 4.8,
            isFavorite = false
        ),
        Restaurant(
            id = "2",
            name = "Hindin Han",
            cuisine = "Bosanska Kuhinja",
            categoryId = "4",
            description = "Premium sushi and sashimi prepared by expert chefs in a modern, relaxing atmosphere.",
            imageResId = R.drawable.restaurant_placeholder_2,
            location = "Baščaršija",
            address = "Brodac 1",
            avgPrice = 25.3,
            rating = 4.9,
            isFavorite = true
        ),
        Restaurant(
            id = "3",
            name = "Park Prinčeva",
            cuisine = "Internacionalna Kuhinja",
            categoryId = "4",
            description = "Spicy, vibrant, and delicious! Come enjoy the best tacos and margaritas in town.",
            imageResId = R.drawable.restaurant_placeholder_3,
            location = "Marijin Dvor",
            address = "Iza Hrida 7",
            avgPrice = 55.5,
            rating = 4.5,
            isFavorite = true
        ),
        Restaurant(
            id = "4",
            name = "Dveri",
            cuisine = "Bosanska Kuhinja",
            categoryId = "3",
            description = "Classic smash burgers, crispy fries, and thick milkshakes. Perfect for a cheat meal.",
            imageResId = R.drawable.restaurant_placeholder_4,
            location = "Baščaršija",
            address = "Baščaršija 5",
            avgPrice = 30.5,
            rating = 4.7,
            isFavorite = false
        ),
        Restaurant(
            id = "5",
            name = "Zeljo",
            cuisine = "Roštilj",
            categoryId = "2",
            description = "Fast, fresh, and piping hot wok dishes customized to your taste.",
            imageResId = R.drawable.restaurant_placeholder_5,
            location = "Baščaršija",
            address = "Bravadžiluk 15",
            avgPrice = 10.5,
            rating = 4.6,
            isFavorite = true
        ),
        Restaurant(
            id = "6",
            name = "Karuzo",
            cuisine = "Italijanska Kuhinja",
            categoryId = "1",
            description = "Experience fine dining with our exquisite French menu and carefully selected wine pairings.",
            imageResId = R.drawable.restaurant_placeholder_6,
            location = "Skenderija",
            address = "Skenderija 5",
            avgPrice = 45.3,
            rating = 4.6,
            isFavorite = false
        ),
        Restaurant(
            id = "7",
            name = "To Be Or Not To Be",
            cuisine = "Internacionalna Kuhinja",
            categoryId = "5",
            description = "Best local cevapi and grilled meat in the region. A must-visit for meat lovers.",
            imageResId = R.drawable.restaurant_placeholder_2,
            location = "Baščaršija",
            address = "Ferhadija 10",
            avgPrice = 35.8,
            rating = 4.9,
            isFavorite = true
        ),
        Restaurant(
            id = "8",
            name = "Mala Kuhinja",
            cuisine = "Fusion Kuhinja",
            categoryId = "7",
            description = "100% plant-based restaurant focusing on organic ingredients and superfoods.",
            imageResId = R.drawable.restaurant_placeholder_3,
            location = "Čengić Vila",
            address = "Čobanija 13",
            avgPrice = 22.4,
            rating = 4.3
        ),
        Restaurant(
            id = "9",
            name = "Morića Han",
            cuisine = "Bosanska Kuhinja",
            categoryId = "4",
            description = "Rich, flavorful curries and fresh tandoori bread baked in a traditional clay oven.",
            imageResId = R.drawable.restaurant_placeholder_4,
            location = "Baščaršija",
            address = "Saraći 77",
            avgPrice = 32.2,
            rating = 4.8,
            isFavorite = true
        ),
        Restaurant(
            id = "10",
            name = "Steakhouse Milord",
            cuisine = "Roštilj & Steakhouse",
            categoryId = "3",
            description = "Premium aged steaks cooked to perfection over an open wood fire grill.",
            imageResId = R.drawable.restaurant_placeholder_5,
            location = "Nedžarići",
            address = "Adema Buće 160",
            avgPrice = 50.0,
            rating = 4.4,
            isFavorite = false
        )
    )

    val foodDishes = listOf(
        FoodDish("1", "1", "Spaghetti Carbonara", R.drawable.meal_1),
        FoodDish("2", "1", "Margherita Pizza", R.drawable.meal_6),
        FoodDish("3", "1", "Bruschetta", R.drawable.meal_3),
        FoodDish("4", "2", "Spicy Tuna Roll", R.drawable.meal_2),
        FoodDish("5", "2", "Salmon Sashimi", R.drawable.meal_1),
        FoodDish("6", "2", "Beef Tacos", R.drawable.meal_5),
        FoodDish("7", "2", "Chicken Burrito", R.drawable.meal_3),
        FoodDish("8", "2", "Nachos Supreme", R.drawable.meal_4),
        FoodDish("9", "4", "Double Smash Burger", R.drawable.meal_1),
        FoodDish("10", "4", "Loaded Fries", R.drawable.meal_2),
        FoodDish("11", "5", "Kung Pao Chicken", R.drawable.meal_4),
        FoodDish("12", "5", "Spring Rolls", R.drawable.meal_3),
        FoodDish("13", "6", "Ratatouille", R.drawable.meal_2),
        FoodDish("14", "6", "Croissant", R.drawable.meal_6),
        FoodDish("15", "7", "Ćevapi (10)", R.drawable.meal_1),
        FoodDish("16", "7", "Teleća Čorba", R.drawable.meal_4),
        FoodDish("17", "8", "Quinoa Salad", R.drawable.meal_2),
        FoodDish("18", "8", "Avocado Toast", R.drawable.meal_3),
        FoodDish("19", "9", "Chicken Tikka", R.drawable.meal_1),
        FoodDish("20", "10", "Ribeye Steak", R.drawable.meal_1)
    )

    val drinks = listOf(
        Drink("1", "1", "House Red Wine", R.drawable.drink_1),
        Drink("2", "1", "Espresso", R.drawable.drink_2),
        Drink("3", "1", "Lemonade", R.drawable.drink_3),
        Drink("4", "2", "Matcha Tea", R.drawable.drink_2),
        Drink("5", "2", "Asahi Beer", R.drawable.drink_4),
        Drink("6", "2", "Margarita", R.drawable.drink_5),
        Drink("7", "2", "Corona Extra", R.drawable.drink_6),
        Drink("8", "4", "Vanilla Milkshake", R.drawable.drink_1),
        Drink("9", "4", "Coca Cola", R.drawable.drink_3),
        Drink("10", "5", "Jasmine Tea", R.drawable.drink_2),
        Drink("11", "6", "Champagne", R.drawable.drink_4),
        Drink("12", "6", "Sparkling Water", R.drawable.drink_5),
        Drink("13", "7", "Ayran", R.drawable.drink_1),
        Drink("14", "7", "Bosnian Coffee", R.drawable.drink_2),
        Drink("15", "8", "Green Smoothie", R.drawable.drink_3),
        Drink("16", "8", "Kombucha", R.drawable.drink_4),
        Drink("17", "9", "Mango Lassi", R.drawable.drink_5),
        Drink("18", "9", "Masala Chai", R.drawable.drink_2),
        Drink("19", "10", "Craft Beer", R.drawable.drink_6),
        Drink("20", "10", "Whiskey Sour", R.drawable.drink_1)
    )
}