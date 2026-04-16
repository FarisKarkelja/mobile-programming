package com.example.mobile_programming.data

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.Drink
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.ALLERGENS
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDish
import com.example.mobile_programming.presentation.ui.screens.profile.util.User

object HardcodedData {
    val locations = listOf(
        "Location", "Dobrinja", "Ilidža", "Nedžarići", "Alipašino Polje", "Otoka",
        "Čengić Vila", "Malta", "Pofalići", "Marijin Dvor",
        "Skenderija", "Baščaršija", "Vijećnica", "Vogošća"
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
        FoodDish(
            "1",
            "1",
            "Spaghetti Carbonara",
            R.drawable.meal_1,
            14.50,
            "Classic Italian...",
            "20 min",
            "Medium",
            "650 kcal",
            ALLERGENS.LACTOSE_FREE
        ),
        FoodDish(
            "2",
            "1",
            "Margherita Pizza",
            R.drawable.meal_6,
            12.00,
            "Traditional pizza...",
            "15 min",
            "Large",
            "800 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "3",
            "1",
            "Bruschetta",
            R.drawable.meal_3,
            8.50,
            "Toasted bread...",
            "10 min",
            "Small",
            "250 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "4",
            "2",
            "Spicy Tuna Roll",
            R.drawable.meal_2,
            16.00,
            "Fresh tuna...",
            "25 min",
            "8 pieces",
            "320 kcal",
            ALLERGENS.GLUTEN_FREE
        ),
        FoodDish(
            "5",
            "2",
            "Salmon Sashimi",
            R.drawable.meal_1,
            18.00,
            "Thinly sliced...",
            "15 min",
            "6 pieces",
            "200 kcal",
            ALLERGENS.GLUTEN_FREE
        ),
        FoodDish(
            "6",
            "2",
            "Beef Tacos",
            R.drawable.meal_5,
            11.00,
            "Three corn...",
            "15 min",
            "3 pieces",
            "450 kcal",
            ALLERGENS.GLUTEN_FREE
        ),
        FoodDish(
            "7",
            "2",
            "Chicken Burrito",
            R.drawable.meal_3,
            13.50,
            "Large flour...",
            "20 min",
            "Large",
            "750 kcal",
            ALLERGENS.LACTOSE_FREE
        ),
        FoodDish(
            "8",
            "2",
            "Nachos Supreme",
            R.drawable.meal_4,
            10.00,
            "Crispy chips...",
            "10 min",
            "Shared",
            "600 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "9",
            "4",
            "Double Smash Burger",
            R.drawable.meal_1,
            15.00,
            "Two juicy...",
            "15 min",
            "Regular",
            "850 kcal",
            ALLERGENS.LACTOSE_FREE
        ),
        FoodDish(
            "10",
            "4",
            "Loaded Fries",
            R.drawable.meal_2,
            7.50,
            "Crispy fries...",
            "10 min",
            "Medium",
            "500 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "11",
            "5",
            "Kung Pao Chicken",
            R.drawable.meal_4,
            14.00,
            "Spicy Chinese...",
            "20 min",
            "Large",
            "550 kcal",
            ALLERGENS.GLUTEN_FREE
        ),
        FoodDish(
            "12",
            "5",
            "Spring Rolls",
            R.drawable.meal_3,
            6.00,
            "Crispy vegetable...",
            "12 min",
            "4 pieces",
            "280 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "13",
            "6",
            "Ratatouille",
            R.drawable.meal_2,
            13.00,
            "Traditional French...",
            "35 min",
            "Medium",
            "320 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "14",
            "6",
            "Croissant",
            R.drawable.meal_6,
            4.50,
            "Buttery pastry...",
            "5 min",
            "Small",
            "350 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "15",
            "7",
            "Ćevapi (10)",
            R.drawable.meal_1,
            12.00,
            "Traditional grilled...",
            "15 min",
            "10 pieces",
            "900 kcal",
            ALLERGENS.LACTOSE_FREE
        ),
        FoodDish(
            "16",
            "7",
            "Teleća Čorba",
            R.drawable.meal_4,
            6.00,
            "Hearty veal...",
            "15 min",
            "Bowl",
            "300 kcal",
            ALLERGENS.GLUTEN_FREE
        ),
        FoodDish(
            "17",
            "8",
            "Quinoa Salad",
            R.drawable.meal_2,
            11.50,
            "Nutritious mix...",
            "15 min",
            "Medium",
            "380 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "18",
            "8",
            "Avocado Toast",
            R.drawable.meal_3,
            9.50,
            "Sliced avocado...",
            "10 min",
            "1 slice",
            "420 kcal",
            ALLERGENS.VEGETARIAN
        ),
        FoodDish(
            "19",
            "9",
            "Chicken Tikka",
            R.drawable.meal_1,
            15.50,
            "Boneless chicken...",
            "25 min",
            "Large",
            "480 kcal",
            ALLERGENS.GLUTEN_FREE
        ),
        FoodDish(
            "20",
            "10",
            "Ribeye Steak",
            R.drawable.meal_1,
            32.00,
            "Premium grilled...",
            "30 min",
            "Large",
            "950 kcal",
            ALLERGENS.GLUTEN_FREE
        )
    )

    val drinks = listOf(
        Drink(
            "1",
            "1",
            "House Red Wine",
            R.drawable.drink_1,
            7.00,
            "A fine selection...",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "2", "1", "Espresso", R.drawable.drink_2, 3.00, "Rich coffee...",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "3", "1", "Lemonade", R.drawable.drink_3, 4.50, "Fresh lemons...",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "4",
            "2",
            "Matcha Tea",
            R.drawable.drink_2,
            5.50,
            "Authentic Japanese...",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "5", "2", "Asahi Beer", R.drawable.drink_4, 6.00, "Japan's popular...",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "6", "2", "Margarita", R.drawable.drink_5, 9.00, "Classic cocktail...",
            isAlcoholic = true,
            isSugarFree = false
        ),
        Drink(
            "7", "2", "Corona Extra", R.drawable.drink_6, 5.50, "Light Mexican...",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "8",
            "4",
            "Vanilla Milkshake",
            R.drawable.drink_1,
            6.50,
            "Creamy vanilla...",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "9",
            "4",
            "Coca Cola",
            R.drawable.drink_3,
            3.50,
            "Classic carbonated...",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "10", "5", "Jasmine Tea", R.drawable.drink_2, 4.00, "Fragrant green...",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "11", "6", "Champagne", R.drawable.drink_4, 15.00, "Elegant French...",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "12", "6", "Sparkling Water", R.drawable.drink_5, 3.00, "Refreshing...",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "13", "7", "Ayran", R.drawable.drink_1, 2.50, "Traditional salty...",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "14",
            "7",
            "Bosnian Coffee",
            R.drawable.drink_2,
            3.50,
            "Strong coffee...",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "15",
            "8",
            "Green Smoothie",
            R.drawable.drink_3,
            7.50,
            "Healthy blend...",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "16", "8", "Kombucha", R.drawable.drink_4, 6.50, "Fermented tea...",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "17", "9", "Mango Lassi", R.drawable.drink_5, 5.00, "Creamy Indian...",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "18",
            "9",
            "Masala Chai",
            R.drawable.drink_2,
            4.50,
            "Black tea brewed...",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "19", "10", "Craft Beer", R.drawable.drink_6, 7.00, "Locally brewed...",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "20", "10", "Whiskey Sour", R.drawable.drink_1, 10.00, "Classic mix...",
            isAlcoholic = true,
            isSugarFree = false
        )
    )
}