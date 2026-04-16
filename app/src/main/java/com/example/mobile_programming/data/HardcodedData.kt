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
            "Bey's Soup",
            R.drawable.meal_1,
            9.00,
            "A traditional Bosnian creamy chicken soup with okra and vegetables. It is slowly simmered to perfection and served as a warm starter.",
            "20 min",
            "Bowl",
            "320 kcal",
            listOf(ALLERGENS.HALAL)
        ),
        FoodDish(
            "2",
            "2",
            "Klepe",
            R.drawable.meal_2,
            14.00,
            "Traditional Bosnian minced meat dumplings served with a rich garlic yogurt sauce. These handmade delights are the ultimate local comfort food.",
            "25 min",
            "Large",
            "680 kcal",
            listOf(ALLERGENS.HALAL)
        ),
        FoodDish(
            "3",
            "5",
            "Sarajevski Ćevapi",
            R.drawable.meal_3,
            12.00,
            "The world-famous grilled minced meat sausages served in a fresh somun bread. Pair them with onions and kaymak for the most authentic experience in Baščaršija.",
            "15 min",
            "10 pieces",
            "850 kcal",
            listOf(ALLERGENS.HALAL, ALLERGENS.LACTOSE_FREE)
        ),
        FoodDish(
            "4",
            "4",
            "Baked Veal with Potatoes",
            R.drawable.meal_4,
            22.00,
            "Tender veal slow-roasted under a metal dome (sač) until the meat falls off the bone. The potatoes absorb all the natural juices for an incredible flavor.",
            "45 min",
            "Large",
            "920 kcal",
            listOf(ALLERGENS.GLUTEN_FREE, ALLERGENS.HALAL)
        ),
        FoodDish(
            "5",
            "8",
            "Vegan Quinoa Bowl",
            R.drawable.meal_5,
            16.50,
            "A colorful mix of organic quinoa, roasted chickpeas, and fresh avocado. It is topped with a light lemon-tahini dressing and toasted seeds.",
            "15 min",
            "Medium",
            "410 kcal",
            listOf(ALLERGENS.VEGAN, ALLERGENS.VEGETARIAN, ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "6",
            "6",
            "Truffle Pasta",
            R.drawable.meal_6,
            28.00,
            "Handmade tagliatelle tossed in a creamy sauce made with premium Istrian black truffles. A sophisticated dish that brings a touch of fine dining to Sarajevo.",
            "20 min",
            "Regular",
            "720 kcal",
            listOf(ALLERGENS.VEGETARIAN)
        ),
        FoodDish(
            "7",
            "10",
            "Tomahawk Steak",
            R.drawable.meal_1,
            85.00,
            "A massive, bone-in ribeye steak dry-aged for 21 days and grilled over charcoal. It is served with rosemary-infused butter and grilled vegetables.",
            "35 min",
            "Extra Large",
            "1200 kcal",
            listOf(ALLERGENS.GLUTEN_FREE, ALLERGENS.HALAL)
        ),
        FoodDish(
            "8",
            "9",
            "Stuffed Peppers",
            R.drawable.meal_2,
            13.00,
            "Bell peppers filled with a mixture of seasoned ground beef and rice, slow-cooked in a tomato broth. Just like your Bosnian grandmother used to make.",
            "30 min",
            "2 pieces",
            "540 kcal",
            listOf(ALLERGENS.HALAL, ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "9",
            "3",
            "Grilled Salmon",
            R.drawable.meal_3,
            32.00,
            "Fresh Atlantic salmon fillet seared to a crisp finish and served on a bed of sautéed spinach. Accompanied by a light lemon and herb infused butter.",
            "20 min",
            "Medium",
            "480 kcal",
            listOf(ALLERGENS.GLUTEN_FREE, ALLERGENS.LACTOSE_FREE)
        ),
        FoodDish(
            "10",
            "1",
            "Sogan Dolma",
            R.drawable.meal_4,
            11.50,
            "Onion bulbs stuffed with a savory meat and rice filling, slowly braised in a mild sauce. A delicate and sweet-savory specialty of traditional Bosnian cuisine.",
            "40 min",
            "Medium",
            "460 kcal",
            listOf(ALLERGENS.HALAL)
        ),
        FoodDish(
            "11",
            "7",
            "Platter for Two",
            R.drawable.meal_5,
            45.00,
            "A giant mix of grilled meats including ćevapi, sudžukice, and chicken skewers. Served with fries, ajvar, and plenty of fresh onions.",
            "25 min",
            "Shared",
            "1800 kcal",
            listOf(ALLERGENS.HALAL)
        ),
        FoodDish(
            "12",
            "8",
            "Sweet Potato Curry",
            R.drawable.meal_6,
            15.00,
            "A warming coconut milk curry with sweet potatoes, spinach, and aromatic spices. This dish is entirely plant-based and perfect for a healthy lunch.",
            "20 min",
            "Medium",
            "390 kcal",
            listOf(ALLERGENS.VEGAN, ALLERGENS.VEGETARIAN, ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "13",
            "4",
            "Rustic Pizza",
            R.drawable.meal_1,
            14.00,
            "Thin-crust pizza topped with local smoked beef, mushrooms, and fresh mozzarella. Baked in a traditional wood-fired oven for a smoky finish.",
            "15 min",
            "Large",
            "950 kcal",
            listOf(ALLERGENS.HALAL)
        ),
        FoodDish(
            "14",
            "6",
            "Duck Confit",
            R.drawable.meal_2,
            38.00,
            "Classic French-style duck leg slow-cooked in its own fat until tender and crispy. Served with a side of mashed potatoes and red wine reduction.",
            "40 min",
            "Medium",
            "820 kcal",
            listOf(ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "15",
            "5",
            "Sudžukice in Somun",
            R.drawable.meal_3,
            10.00,
            "Spicy Bosnian sausages grilled over hot coals and tucked into a warm somun bread. A favorite quick bite for locals wandering through Baščaršija.",
            "10 min",
            "5 pieces",
            "710 kcal",
            listOf(ALLERGENS.HALAL, ALLERGENS.LACTOSE_FREE)
        ),
        FoodDish(
            "16",
            "9",
            "Bosnian Pot (Bosanski Lonac)",
            R.drawable.meal_4,
            18.00,
            "A hearty stew featuring layers of meat and various vegetables slow-cooked for hours. It represents the historical soul of Bosnian communal dining.",
            "60 min",
            "Large",
            "600 kcal",
            listOf(ALLERGENS.HALAL, ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "17",
            "2",
            "Japrak",
            R.drawable.meal_5,
            15.00,
            "Minced meat and rice wrapped in vine leaves, typical for the Herzegovina region. These small rolls are packed with flavor and served with sour cream.",
            "30 min",
            "6 pieces",
            "430 kcal",
            listOf(ALLERGENS.HALAL, ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "18",
            "3",
            "Mushroom Risotto",
            R.drawable.meal_6,
            17.50,
            "Creamy Arborio rice cooked with a variety of forest mushrooms and finished with parmesan cheese. It offers a rich, earthy flavor and a silky texture.",
            "25 min",
            "Medium",
            "520 kcal",
            listOf(ALLERGENS.VEGETARIAN, ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "19",
            "10",
            "Lamb Chops",
            R.drawable.meal_1,
            36.00,
            "Succulent lamb chops marinated in garlic and rosemary, then grilled to your preference. Served with a side of mint jelly and roasted root vegetables.",
            "25 min",
            "Regular",
            "780 kcal",
            listOf(ALLERGENS.HALAL, ALLERGENS.GLUTEN_FREE)
        ),
        FoodDish(
            "20",
            "7",
            "Baklava Duo",
            R.drawable.meal_2,
            7.00,
            "A pair of traditional walnut-filled pastries drenched in sweet sugar syrup. The perfect sugary end to a rich Bosnian meal.",
            "5 min",
            "Small",
            "550 kcal",
            listOf(ALLERGENS.VEGETARIAN)
        )
    )

    val drinks = listOf(
        Drink(
            "1",
            "1",
            "Bosnian Coffee",
            R.drawable.drink_1,
            4.00,
            "Strong, unfiltered coffee served in a traditional copper dzezva with a sugar cube and Turkish delight. It is the heart of Sarajevo's social ritual.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "2",
            "5",
            "Cold Ayran",
            R.drawable.drink_2,
            3.00,
            "A refreshing, salty yogurt-based drink that perfectly complements grilled meats. It is served chilled and helps with digestion after a heavy meal.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "3",
            "7",
            "Elderberry Juice",
            R.drawable.drink_3,
            4.50,
            "Homemade syrup made from elderberry flowers collected from the Bosnian mountains. It is a sweet, floral, and nostalgic drink for many locals.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "4",
            "10",
            "Sarajevsko Beer",
            R.drawable.drink_4,
            5.00,
            "The iconic local lager brewed in the heart of the city since 1864. It has a crisp, refreshing taste that pairs well with any dish.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "5",
            "6",
            "Chardonnay",
            R.drawable.drink_5,
            9.00,
            "A glass of premium dry white wine with notes of apple and citrus. Perfectly chilled to accompany seafood or creamy pasta dishes.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "6",
            "3",
            "Virgin Mojito",
            R.drawable.drink_6,
            7.50,
            "A refreshing mocktail made with fresh lime juice, crushed mint, and sparkling water. It is a perfect non-alcoholic choice for a hot summer day.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "7",
            "8",
            "Green Detox Juice",
            R.drawable.drink_1,
            8.50,
            "A cold-pressed blend of spinach, green apple, cucumber, and ginger. This nutrient-packed drink is designed to boost your energy naturally.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "8",
            "2",
            "Turkish Tea",
            R.drawable.drink_2,
            3.50,
            "Traditional black tea served in small tulip-shaped glasses. It is a staple in Baščaršija for those who enjoy a long conversation.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "9",
            "4",
            "Hot Chocolate",
            R.drawable.drink_3,
            5.50,
            "Rich and thick dark chocolate topped with a mountain of whipped cream. A favorite treat during the snowy winter months in Sarajevo.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "10",
            "9",
            "Rose Sherbet",
            R.drawable.drink_4,
            4.00,
            "A traditional Ottoman-era drink made from rose petals and sugar. It is incredibly fragrant and offers a unique taste of history.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "11",
            "1",
            "Rakija (Plum)",
            R.drawable.drink_5,
            5.00,
            "A potent traditional fruit brandy made from fermented plums. Usually served as an aperitif to kickstart your appetite.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "12",
            "6",
            "Espresso Martini",
            R.drawable.drink_6,
            12.00,
            "A sophisticated cocktail combining premium vodka with a fresh shot of espresso. It is the perfect pick-me-up for a night out in the city.",
            isAlcoholic = true,
            isSugarFree = false
        ),
        Drink(
            "13",
            "5",
            "Sparkling Water",
            R.drawable.drink_1,
            3.00,
            "Refreshing mineral water sourced from local springs. A simple and essential accompaniment to any cup of Bosnian coffee.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "14",
            "7",
            "Blueberry Smoothie",
            R.drawable.drink_2,
            7.00,
            "Blended wild blueberries from the Olympic mountains mixed with yogurt and a hint of honey. It is thick, sweet, and full of antioxidants.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "15",
            "3",
            "Cabernet Sauvignon",
            R.drawable.drink_3,
            10.00,
            "A full-bodied red wine with deep flavors of blackcurrant and oak. Ideal for pairing with grilled steaks or aged cheeses.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        Drink(
            "16",
            "8",
            "Iced Matcha Latte",
            R.drawable.drink_4,
            6.50,
            "Ceremonial grade matcha whisked with cold almond milk and a touch of agave. A trendy and healthy alternative for caffeine lovers.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "17",
            "10",
            "Old Fashioned",
            R.drawable.drink_5,
            11.00,
            "A classic gentleman's cocktail made with bourbon, bitters, and a twist of citrus peel. Slow-sipped and full of character.",
            isAlcoholic = true,
            isSugarFree = false
        ),
        Drink(
            "18",
            "4",
            "Lemonade with Ginger",
            R.drawable.drink_6,
            5.00,
            "Freshly squeezed lemons mixed with spicy ginger root and honey. A powerful drink that is both refreshing and immune-boosting.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        Drink(
            "19",
            "9",
            "Earl Grey Tea",
            R.drawable.drink_1,
            4.00,
            "Fine black tea scented with oil of bergamot, served with a side of milk or lemon. A classic choice for a quiet afternoon.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        Drink(
            "20",
            "2",
            "Pomegranate Juice",
            R.drawable.drink_2,
            6.00,
            "Freshly pressed pomegranate juice, tart and sweet at the same time. This vibrant red drink is as healthy as it is delicious.",
            isAlcoholic = false,
            isSugarFree = false
        )
    )
}