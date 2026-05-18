package com.example.mobile_programming.model

import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.Drink
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.Allergen
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
        )
    )

    val foodDishes = listOf(
        FoodDish(
            id = "1",
            restaurantId = "1",
            name = "Bey's Soup",
            imageResId = R.drawable.meal_1,
            price = 9.00,
            description = "A traditional Bosnian creamy chicken soup with okra and vegetables. It is slowly simmered to perfection and served as a warm starter.",
            cookingTime = "20 min",
            servingSize = "Bowl",
            calories = "320 kcal",
            allergens = listOf(Allergen.HALAL)
        ),
        FoodDish(
            id = "2",
            restaurantId = "2",
            name = "Klepe",
            imageResId = R.drawable.meal_2,
            price = 14.00,
            description = "Traditional Bosnian minced meat dumplings served with a rich garlic yogurt sauce. These handmade delights are the ultimate local comfort food.",
            cookingTime = "25 min",
            servingSize = "Large",
            calories = "680 kcal",
            allergens = listOf(Allergen.HALAL)
        ),
        FoodDish(
            id = "3",
            restaurantId = "5",
            name = "Sarajevski Ćevapi",
            imageResId = R.drawable.meal_3,
            price = 12.00,
            description = "The world-famous grilled minced meat sausages served in a fresh somun bread. Pair them with onions and kaymak for the most authentic experience in Baščaršija.",
            cookingTime = "15 min",
            servingSize = "10 pieces",
            calories = "850 kcal",
            allergens = listOf(Allergen.HALAL, Allergen.LACTOSE_FREE)
        ),
        FoodDish(
            id = "4",
            restaurantId = "4",
            name = "Baked Veal with Potatoes",
            imageResId = R.drawable.meal_4,
            price = 22.00,
            description = "Tender veal slow-roasted under a metal dome (sač) until the meat falls off the bone. The potatoes absorb all the natural juices for an incredible flavor.",
            cookingTime = "45 min",
            servingSize = "Large",
            calories = "920 kcal",
            allergens = listOf(Allergen.GLUTEN_FREE, Allergen.HALAL)
        ),
        FoodDish(
            id = "5",
            restaurantId = "8",
            name = "Vegan Quinoa Bowl",
            imageResId = R.drawable.meal_5,
            price = 16.50,
            description = "A colorful mix of organic quinoa, roasted chickpeas, and fresh avocado. It is topped with a light lemon-tahini dressing and toasted seeds.",
            cookingTime = "15 min",
            servingSize = "Medium",
            calories = "410 kcal",
            allergens = listOf(Allergen.VEGAN, Allergen.VEGETARIAN, Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "6",
            restaurantId = "6",
            name = "Truffle Pasta",
            imageResId = R.drawable.meal_6,
            price = 28.00,
            description = "Handmade tagliatelle tossed in a creamy sauce made with premium Istrian black truffles. A sophisticated dish that brings a touch of fine dining to Sarajevo.",
            cookingTime = "20 min",
            servingSize = "Regular",
            calories = "720 kcal",
            allergens = listOf(Allergen.VEGETARIAN)
        ),
        FoodDish(
            id = "7",
            restaurantId = "10",
            name = "Tomahawk Steak",
            imageResId = R.drawable.meal_1,
            price = 85.00,
            description = "A massive, bone-in ribeye steak dry-aged for 21 days and grilled over charcoal. It is served with rosemary-infused butter and grilled vegetables.",
            cookingTime = "35 min",
            servingSize = "Extra Large",
            calories = "1200 kcal",
            allergens = listOf(Allergen.GLUTEN_FREE, Allergen.HALAL)
        ),
        FoodDish(
            id = "8",
            restaurantId = "9",
            name = "Stuffed Peppers",
            imageResId = R.drawable.meal_2,
            price = 13.00,
            description = "Bell peppers filled with a mixture of seasoned ground beef and rice, slow-cooked in a tomato broth. Just like your Bosnian grandmother used to make.",
            cookingTime = "30 min",
            servingSize = "2 pieces",
            calories = "540 kcal",
            allergens = listOf(Allergen.HALAL, Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "9",
            restaurantId = "3",
            name = "Grilled Salmon",
            imageResId = R.drawable.meal_3,
            price = 32.00,
            description = "Fresh Atlantic salmon fillet seared to a crisp finish and served on a bed of sautéed spinach. Accompanied by a light lemon and herb infused butter.",
            cookingTime = "20 min",
            servingSize = "Medium",
            calories = "480 kcal",
            allergens = listOf(Allergen.GLUTEN_FREE, Allergen.LACTOSE_FREE)
        ),
        FoodDish(
            id = "10",
            restaurantId = "1",
            name = "Sogan Dolma",
            imageResId = R.drawable.meal_4,
            price = 11.50,
            description = "Onion bulbs stuffed with a savory meat and rice filling, slowly braised in a mild sauce. A delicate and sweet-savory specialty of traditional Bosnian cuisine.",
            cookingTime = "40 min",
            servingSize = "Medium",
            calories = "460 kcal",
            allergens = listOf(Allergen.HALAL)
        ),
        FoodDish(
            id = "11",
            restaurantId = "7",
            name = "Platter for Two",
            imageResId = R.drawable.meal_5,
            price = 45.00,
            description = "A giant mix of grilled meats including ćevapi, sudžukice, and chicken skewers. Served with fries, ajvar, and plenty of fresh onions.",
            cookingTime = "25 min",
            servingSize = "Shared",
            calories = "1800 kcal",
            allergens = listOf(Allergen.HALAL)
        ),
        FoodDish(
            id = "12",
            restaurantId = "8",
            name = "Sweet Potato Curry",
            imageResId = R.drawable.meal_6,
            price = 15.00,
            description = "A warming coconut milk curry with sweet potatoes, spinach, and aromatic spices. This dish is entirely plant-based and perfect for a healthy lunch.",
            cookingTime = "20 min",
            servingSize = "Medium",
            calories = "390 kcal",
            allergens = listOf(Allergen.VEGAN, Allergen.VEGETARIAN, Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "13",
            restaurantId = "4",
            name = "Rustic Pizza",
            imageResId = R.drawable.meal_1,
            price = 14.00,
            description = "Thin-crust pizza topped with local smoked beef, mushrooms, and fresh mozzarella. Baked in a traditional wood-fired oven for a smoky finish.",
            cookingTime = "15 min",
            servingSize = "Large",
            calories = "950 kcal",
            allergens = listOf(Allergen.HALAL)
        ),
        FoodDish(
            id = "14",
            restaurantId = "6",
            name = "Duck Confit",
            imageResId = R.drawable.meal_2,
            price = 38.00,
            description = "Classic French-style duck leg slow-cooked in its own fat until tender and crispy. Served with a side of mashed potatoes and red wine reduction.",
            cookingTime = "40 min",
            servingSize = "Medium",
            calories = "820 kcal",
            allergens = listOf(Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "15",
            restaurantId = "5",
            name = "Sudžukice in Somun",
            imageResId = R.drawable.meal_3,
            price = 10.00,
            description = "Spicy Bosnian sausages grilled over hot coals and tucked into a warm somun bread. A favorite quick bite for locals wandering through Baščaršija.",
            cookingTime = "10 min",
            servingSize = "5 pieces",
            calories = "710 kcal",
            allergens = listOf(Allergen.HALAL, Allergen.LACTOSE_FREE)
        ),
        FoodDish(
            id = "16",
            restaurantId = "9",
            name = "Bosnian Pot (Bosanski Lonac)",
            imageResId = R.drawable.meal_4,
            price = 18.00,
            description = "A hearty stew featuring layers of meat and various vegetables slow-cooked for hours. It represents the historical soul of Bosnian communal dining.",
            cookingTime = "60 min",
            servingSize = "Large",
            calories = "600 kcal",
            allergens = listOf(Allergen.HALAL, Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "17",
            restaurantId = "2",
            name = "Japrak",
            imageResId = R.drawable.meal_5,
            price = 15.00,
            description = "Minced meat and rice wrapped in vine leaves, typical for the Herzegovina region. These small rolls are packed with flavor and served with sour cream.",
            cookingTime = "30 min",
            servingSize = "6 pieces",
            calories = "430 kcal",
            allergens = listOf(Allergen.HALAL, Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "18",
            restaurantId = "3",
            name = "Mushroom Risotto",
            imageResId = R.drawable.meal_6,
            price = 17.50,
            description = "Creamy Arborio rice cooked with a variety of forest mushrooms and finished with parmesan cheese. It offers a rich, earthy flavor and a silky texture.",
            cookingTime = "25 min",
            servingSize = "Medium",
            calories = "520 kcal",
            allergens = listOf(Allergen.VEGETARIAN, Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "19",
            restaurantId = "10",
            name = "Lamb Chops",
            imageResId = R.drawable.meal_1,
            price = 36.00,
            description = "Succulent lamb chops marinated in garlic and rosemary, then grilled to your preference. Served with a side of mint jelly and roasted root vegetables.",
            cookingTime = "25 min",
            servingSize = "Regular",
            calories = "780 kcal",
            allergens = listOf(Allergen.HALAL, Allergen.GLUTEN_FREE)
        ),
        FoodDish(
            id = "20",
            restaurantId = "7",
            name = "Baklava Duo",
            imageResId = R.drawable.meal_2,
            price = 7.00,
            description = "A pair of traditional walnut-filled pastries drenched in sweet sugar syrup. The perfect sugary end to a rich Bosnian meal.",
            cookingTime = "5 min",
            servingSize = "Small",
            calories = "550 kcal",
            allergens = listOf(Allergen.VEGETARIAN)
        )
    )

    val drinks = listOf(
        Drink(
            id = "1",
            restaurantId = "1",
            name = "Bosnian Coffee",
            imageResId = R.drawable.drink_1,
            price = 4.00,
            description = "Strong, unfiltered coffee served in a traditional copper dzezva with a sugar cube and Turkish delight. It is the heart of Sarajevo's social ritual.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            id = "2",
            restaurantId = "5",
            name = "Cold Ayran",
            imageResId = R.drawable.drink_2,
            price = 3.00,
            description = "A refreshing, salty yogurt-based drink that perfectly complements grilled meats. It is served chilled and helps with digestion after a heavy meal.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            id = "3",
            restaurantId = "7",
            name = "Elderberry Juice",
            imageResId = R.drawable.drink_3,
            price = 4.50,
            description = "Homemade syrup made from elderberry flowers collected from the Bosnian mountains. It is a sweet, floral, and nostalgic drink for many locals.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            id = "4",
            restaurantId = "10",
            name = "Sarajevsko Beer",
            imageResId = R.drawable.drink_4,
            price = 5.00,
            description = "The iconic local lager brewed in the heart of the city since 1864. It has a crisp, refreshing taste that pairs well with any dish.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            id = "5",
            restaurantId = "6",
            name = "Chardonnay",
            imageResId = R.drawable.drink_5,
            price = 9.00,
            description = "A glass of premium dry white wine with notes of apple and citrus. Perfectly chilled to accompany seafood or creamy pasta dishes.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            id = "6",
            restaurantId = "3",
            name = "Virgin Mojito",
            imageResId = R.drawable.drink_6,
            price = 7.50,
            description = "A refreshing mocktail made with fresh lime juice, crushed mint, and sparkling water. It is a perfect non-alcoholic choice for a hot summer day.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            id = "7",
            restaurantId = "8",
            name = "Green Detox Juice",
            imageResId = R.drawable.drink_1,
            price = 8.50,
            description = "A cold-pressed blend of spinach, green apple, cucumber, and ginger. This nutrient-packed drink is designed to boost your energy naturally.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            id = "8",
            restaurantId = "2",
            name = "Turkish Tea",
            imageResId = R.drawable.drink_2,
            price = 3.50,
            description = "Traditional black tea served in small tulip-shaped glasses. It is a staple in Baščaršija for those who enjoy a long conversation.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            id = "9",
            restaurantId = "4",
            name = "Hot Chocolate",
            imageResId = R.drawable.drink_3,
            price = 5.50,
            description = "Rich and thick dark chocolate topped with a mountain of whipped cream. A favorite treat during the snowy winter months in Sarajevo.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            id = "10",
            restaurantId = "9",
            name = "Rose Sherbet",
            imageResId = R.drawable.drink_4,
            price = 4.00,
            description = "A traditional Ottoman-era drink made from rose petals and sugar. It is incredibly fragrant and offers a unique taste of history.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            id = "11",
            restaurantId = "1",
            name = "Rakija (Plum)",
            imageResId = R.drawable.drink_5,
            price = 5.00,
            description = "A potent traditional fruit brandy made from fermented plums. Usually served as an aperitif to kickstart your appetite.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            id = "12",
            restaurantId = "6",
            name = "Espresso Martini",
            imageResId = R.drawable.drink_6,
            price = 12.00,
            description = "A sophisticated cocktail combining premium vodka with a fresh shot of espresso. It is the perfect pick-me-up for a night out in the city.",
            isAlcoholic = true,
            isSugarFree = false
        ),
        Drink(
            id = "13",
            restaurantId = "5",
            name = "Sparkling Water",
            imageResId = R.drawable.drink_1,
            price = 3.00,
            description = "Refreshing mineral water sourced from local springs. A simple and essential accompaniment to any cup of Bosnian coffee.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            id = "14",
            restaurantId = "7",
            name = "Blueberry Smoothie",
            imageResId = R.drawable.drink_2,
            price = 7.00,
            description = "Blended wild blueberries from the Olympic mountains mixed with yogurt and a hint of honey. It is thick, sweet, and full of antioxidants.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            id = "15",
            restaurantId = "3",
            name = "Cabernet Sauvignon",
            imageResId = R.drawable.drink_3,
            price = 10.00,
            description = "A full-bodied red wine with deep flavors of blackcurrant and oak. Ideal for pairing with grilled steaks or aged cheeses.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            id = "16",
            restaurantId = "8",
            name = "Iced Matcha Latte",
            imageResId = R.drawable.drink_4,
            price = 6.50,
            description = "Ceremonial grade matcha whisked with cold almond milk and a touch of agave. A trendy and healthy alternative for caffeine lovers.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            id = "17",
            restaurantId = "10",
            name = "Old Fashioned",
            imageResId = R.drawable.drink_5,
            price = 11.00,
            description = "A classic gentleman's cocktail made with bourbon, bitters, and a twist of citrus peel. Slow-sipped and full of character.",
            isAlcoholic = true,
            isSugarFree = false
        ),
        Drink(
            id = "18",
            restaurantId = "4",
            name = "Lemonade with Ginger",
            imageResId = R.drawable.drink_6,
            price = 5.00,
            description = "Freshly squeezed lemons mixed with spicy ginger root and honey. A powerful drink that is both refreshing and immune-boosting.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            id = "19",
            restaurantId = "9",
            name = "Earl Grey Tea",
            imageResId = R.drawable.drink_1,
            price = 4.00,
            description = "Fine black tea scented with oil of bergamot, served with a side of milk or lemon. A classic choice for a quiet afternoon.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            id = "20",
            restaurantId = "2",
            name = "Pomegranate Juice",
            imageResId = R.drawable.drink_2,
            price = 6.00,
            description = "Freshly pressed pomegranate juice, tart and sweet at the same time. This vibrant red drink is as healthy as it is delicious.",
            isAlcoholic = false,
            isSugarFree = false
        )
    )
}