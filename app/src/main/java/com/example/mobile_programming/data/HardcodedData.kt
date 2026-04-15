package com.example.mobile_programming.data

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.Drink
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
            "1", "1", "Spaghetti Carbonara", R.drawable.meal_1, 14.50,
            "Classic Italian pasta with creamy eggs, hard cheese, cured pork, and black pepper.",
            "20 min", "Medium", "650 kcal"
        ),
        FoodDish(
            "2", "1", "Margherita Pizza", R.drawable.meal_6, 12.00,
            "Traditional pizza with tomato sauce, fresh mozzarella, basil, and extra virgin olive oil.",
            "15 min", "Large", "800 kcal"
        ),
        FoodDish(
            "3", "1", "Bruschetta", R.drawable.meal_3, 8.50,
            "Toasted bread rubbed with garlic and topped with tomatoes, olive oil, and salt.",
            "10 min", "Small", "250 kcal"
        ),
        FoodDish(
            "4", "2", "Spicy Tuna Roll", R.drawable.meal_2, 16.00,
            "Fresh tuna mixed with spicy mayo and cucumber, wrapped in seaweed and rice.",
            "25 min", "8 pieces", "320 kcal"
        ),
        FoodDish(
            "5", "2", "Salmon Sashimi", R.drawable.meal_1, 18.00,
            "Thinly sliced raw salmon served with wasabi, ginger, and soy sauce.",
            "15 min", "6 pieces", "200 kcal"
        ),
        FoodDish(
            "6", "2", "Beef Tacos", R.drawable.meal_5, 11.00,
            "Three corn tortillas filled with seasoned beef, onions, cilantro, and fresh salsa.",
            "15 min", "3 pieces", "450 kcal"
        ),
        FoodDish(
            "7", "2", "Chicken Burrito", R.drawable.meal_3, 13.50,
            "Large flour tortilla stuffed with grilled chicken, rice, beans, cheese, and guacamole.",
            "20 min", "Large", "750 kcal"
        ),
        FoodDish(
            "8", "2", "Nachos Supreme", R.drawable.meal_4, 10.00,
            "Crispy tortilla chips topped with melted cheese, jalapeños, sour cream, and olives.",
            "10 min", "Shared", "600 kcal"
        ),
        FoodDish(
            "9", "4", "Double Smash Burger", R.drawable.meal_1, 15.00,
            "Two juicy beef patties with melted cheddar, secret sauce, and pickles on a brioche bun.",
            "15 min", "Regular", "850 kcal"
        ),
        FoodDish(
            "10", "4", "Loaded Fries", R.drawable.meal_2, 7.50,
            "Crispy fries smothered in cheese sauce, bacon bits, and chopped chives.",
            "10 min", "Medium", "500 kcal"
        ),
        FoodDish(
            "11", "5", "Kung Pao Chicken", R.drawable.meal_4, 14.00,
            "Spicy, stir-fried Chinese dish made with chicken, peanuts, vegetables, and chili peppers.",
            "20 min", "Large", "550 kcal"
        ),
        FoodDish(
            "12", "5", "Spring Rolls", R.drawable.meal_3, 6.00,
            "Crispy vegetable-filled rolls served with a sweet and sour dipping sauce.",
            "12 min", "4 pieces", "280 kcal"
        ),
        FoodDish(
            "13", "6", "Ratatouille", R.drawable.meal_2, 13.00,
            "Traditional French Provençal stewed vegetable dish originating from Nice.",
            "35 min", "Medium", "320 kcal"
        ),
        FoodDish(
            "14", "6", "Croissant", R.drawable.meal_6, 4.50,
            "Buttery, flaky, Viennoiserie pastry of Austrian origin, named for its historical crescent shape.",
            "5 min", "Small", "350 kcal"
        ),
        FoodDish(
            "15", "7", "Ćevapi (10)", R.drawable.meal_1, 12.00,
            "Traditional grilled dish of minced meat served in lepinja bread with onions and ajvar.",
            "15 min", "10 pieces", "900 kcal"
        ),
        FoodDish(
            "16", "7", "Teleća Čorba", R.drawable.meal_4, 6.00,
            "Hearty and traditional Bosnian veal cream soup with vegetables.",
            "15 min", "Bowl", "300 kcal"
        ),
        FoodDish(
            "17", "8", "Quinoa Salad", R.drawable.meal_2, 11.50,
            "Nutritious mix of quinoa, cherry tomatoes, cucumbers, spinach, and lemon dressing.",
            "15 min", "Medium", "380 kcal"
        ),
        FoodDish(
            "18", "8", "Avocado Toast", R.drawable.meal_3, 9.50,
            "Sliced avocado on toasted sourdough, topped with chili flakes and a poached egg.",
            "10 min", "1 slice", "420 kcal"
        ),
        FoodDish(
            "19", "9", "Chicken Tikka", R.drawable.meal_1, 15.50,
            "Boneless chicken pieces marinated in spices and yogurt, grilled in a tandoor.",
            "25 min", "Large", "480 kcal"
        ),
        FoodDish(
            "20", "10", "Ribeye Steak", R.drawable.meal_1, 32.00,
            "Premium grilled ribeye steak served with garlic butter and roasted potatoes.",
            "30 min", "Large", "950 kcal"
        )
    )

    val drinks = listOf(
        Drink(
            "1",
            "1",
            "House Red Wine",
            R.drawable.drink_1,
            7.00,
            "A fine selection of local red wine with deep berry notes."
        ),
        Drink(
            "2",
            "1",
            "Espresso",
            R.drawable.drink_2,
            3.00,
            "Rich and intense short coffee made with premium roasted beans."
        ),
        Drink(
            "3",
            "1",
            "Lemonade",
            R.drawable.drink_3,
            4.50,
            "Freshly squeezed lemons with a touch of mint and honey."
        ),
        Drink(
            "4",
            "2",
            "Matcha Tea",
            R.drawable.drink_2,
            5.50,
            "Authentic Japanese powdered green tea with a smooth, earthy taste."
        ),
        Drink(
            "5",
            "2",
            "Asahi Beer",
            R.drawable.drink_4,
            6.00,
            "Japan's most popular dry, crisp, and refreshing lager."
        ),
        Drink(
            "6",
            "2",
            "Margarita",
            R.drawable.drink_5,
            9.00,
            "Classic cocktail with tequila, lime juice, and triple sec, served with a salted rim."
        ),
        Drink(
            "7",
            "2",
            "Corona Extra",
            R.drawable.drink_6,
            5.50,
            "Light and crisp Mexican pale lager served with a slice of lime."
        ),
        Drink(
            "8",
            "4",
            "Vanilla Milkshake",
            R.drawable.drink_1,
            6.50,
            "Creamy vanilla bean ice cream blended with fresh milk and whipped cream."
        ),
        Drink(
            "9",
            "4",
            "Coca Cola",
            R.drawable.drink_3,
            3.50,
            "Classic carbonated soft drink served chilled with ice."
        ),
        Drink(
            "10",
            "5",
            "Jasmine Tea",
            R.drawable.drink_2,
            4.00,
            "Fragrant green tea scented with real jasmine blossoms."
        ),
        Drink(
            "11",
            "6",
            "Champagne",
            R.drawable.drink_4,
            15.00,
            "Elegant French sparkling wine for special celebrations."
        ),
        Drink(
            "12",
            "6",
            "Sparkling Water",
            R.drawable.drink_5,
            3.00,
            "Refreshing carbonated natural mineral water."
        ),
        Drink(
            "13",
            "7",
            "Ayran",
            R.drawable.drink_1,
            2.50,
            "Traditional salty yogurt-based beverage, perfect with grilled meat."
        ),
        Drink(
            "14",
            "7",
            "Bosnian Coffee",
            R.drawable.drink_2,
            3.50,
            "Strong, unfiltered coffee served in a traditional dzezva with rahat lokum."
        ),
        Drink(
            "15",
            "8",
            "Green Smoothie",
            R.drawable.drink_3,
            7.50,
            "Healthy blend of kale, apple, ginger, and spirulina."
        ),
        Drink(
            "16",
            "8",
            "Kombucha",
            R.drawable.drink_4,
            6.50,
            "Fermented, slightly effervescent, sweetened black or green tea drink."
        ),
        Drink(
            "17",
            "9",
            "Mango Lassi",
            R.drawable.drink_5,
            5.00,
            "Creamy Indian yogurt drink blended with sweet ripe mangoes."
        ),
        Drink(
            "18",
            "9",
            "Masala Chai",
            R.drawable.drink_2,
            4.50,
            "Black tea brewed with aromatic Indian spices and milk."
        ),
        Drink(
            "19",
            "10",
            "Craft Beer",
            R.drawable.drink_6,
            7.00,
            "Locally brewed IPA with citrus and pine hop notes."
        ),
        Drink(
            "20",
            "10",
            "Whiskey Sour",
            R.drawable.drink_1,
            10.00,
            "Classic mix of bourbon, lemon juice, and a dash of sugar syrup."
        )
    )
}