package com.example.mobile_programming.model.datasource.local.util

import com.example.mobile_programming.R
import com.example.mobile_programming.model.datasource.local.entity.FoodDishEntity

object FoodDishSeed {
    val defaultFoodDishes = listOf(
        FoodDishEntity(
            id = 1,
            restaurantId = 1,
            name = "Bey's Soup",
            imageResId = R.drawable.meal_1,
            price = 9.00,
            description = "A traditional Bosnian creamy chicken soup with okra and vegetables. It is slowly simmered to perfection and served as a warm starter.",
            cookingTime = "20 min",
            servingSize = "Bowl",
            calories = "320 kcal",
            allergens = listOf(Allergens.HALAL)
        ),
        FoodDishEntity(
            id = 2,
            restaurantId = 2,
            name = "Klepe",
            imageResId = R.drawable.meal_2,
            price = 14.00,
            description = "Traditional Bosnian minced meat dumplings served with a rich garlic yogurt sauce. These handmade delights are the ultimate local comfort food.",
            cookingTime = "25 min",
            servingSize = "Large",
            calories = "680 kcal",
            allergens = listOf(Allergens.HALAL)
        ),
        FoodDishEntity(
            id = 3,
            restaurantId = 5,
            name = "Sarajevski Ćevapi",
            imageResId = R.drawable.meal_3,
            price = 12.00,
            description = "The world-famous grilled minced meat sausages served in a fresh somun bread. Pair them with onions and kaymak for the most authentic experience in Baščaršija.",
            cookingTime = "15 min",
            servingSize = "10 pieces",
            calories = "850 kcal",
            allergens = listOf(Allergens.HALAL, Allergens.LACTOSE_FREE)
        ),
        FoodDishEntity(
            id = 4,
            restaurantId = 4,
            name = "Baked Veal with Potatoes",
            imageResId = R.drawable.meal_4,
            price = 22.00,
            description = "Tender veal slow-roasted under a metal dome (sač) until the meat falls off the bone. The potatoes absorb all the natural juices for an incredible flavor.",
            cookingTime = "45 min",
            servingSize = "Large",
            calories = "920 kcal",
            allergens = listOf(Allergens.GLUTEN_FREE, Allergens.HALAL)
        ),
        FoodDishEntity(
            id = 5,
            restaurantId = 8,
            name = "Vegan Quinoa Bowl",
            imageResId = R.drawable.meal_5,
            price = 16.50,
            description = "A colorful mix of organic quinoa, roasted chickpeas, and fresh avocado. It is topped with a light lemon-tahini dressing and toasted seeds.",
            cookingTime = "15 min",
            servingSize = "Medium",
            calories = "410 kcal",
            allergens = listOf(Allergens.VEGAN, Allergens.VEGETARIAN, Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 6,
            restaurantId = 6,
            name = "Truffle Pasta",
            imageResId = R.drawable.meal_6,
            price = 28.00,
            description = "Handmade tagliatelle tossed in a creamy sauce made with premium Istrian black truffles. A sophisticated dish that brings a touch of fine dining to Sarajevo.",
            cookingTime = "20 min",
            servingSize = "Regular",
            calories = "720 kcal",
            allergens = listOf(Allergens.VEGETARIAN)
        ),
        FoodDishEntity(
            id = 7,
            restaurantId = 10,
            name = "Tomahawk Steak",
            imageResId = R.drawable.meal_1,
            price = 85.00,
            description = "A massive, bone-in ribeye steak dry-aged for 21 days and grilled over charcoal. It is served with rosemary-infused butter and grilled vegetables.",
            cookingTime = "35 min",
            servingSize = "Extra Large",
            calories = "1200 kcal",
            allergens = listOf(Allergens.GLUTEN_FREE, Allergens.HALAL)
        ),
        FoodDishEntity(
            id = 8,
            restaurantId = 9,
            name = "Stuffed Peppers",
            imageResId = R.drawable.meal_2,
            price = 13.00,
            description = "Bell peppers filled with a mixture of seasoned ground beef and rice, slow-cooked in a tomato broth. Just like your Bosnian grandmother used to make.",
            cookingTime = "30 min",
            servingSize = "2 pieces",
            calories = "540 kcal",
            allergens = listOf(Allergens.HALAL, Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 9,
            restaurantId = 3,
            name = "Grilled Salmon",
            imageResId = R.drawable.meal_3,
            price = 32.00,
            description = "Fresh Atlantic salmon fillet seared to a crisp finish and served on a bed of sautéed spinach. Accompanied by a light lemon and herb infused butter.",
            cookingTime = "20 min",
            servingSize = "Medium",
            calories = "480 kcal",
            allergens = listOf(Allergens.GLUTEN_FREE, Allergens.LACTOSE_FREE)
        ),
        FoodDishEntity(
            id = 10,
            restaurantId = 1,
            name = "Sogan Dolma",
            imageResId = R.drawable.meal_4,
            price = 11.50,
            description = "Onion bulbs stuffed with a savory meat and rice filling, slowly braised in a mild sauce. A delicate and sweet-savory specialty of traditional Bosnian cuisine.",
            cookingTime = "40 min",
            servingSize = "Medium",
            calories = "460 kcal",
            allergens = listOf(Allergens.HALAL)
        ),
        FoodDishEntity(
            id = 11,
            restaurantId = 7,
            name = "Platter for Two",
            imageResId = R.drawable.meal_5,
            price = 45.00,
            description = "A giant mix of grilled meats including ćevapi, sudžukice, and chicken skewers. Served with fries, ajvar, and plenty of fresh onions.",
            cookingTime = "25 min",
            servingSize = "Shared",
            calories = "1800 kcal",
            allergens = listOf(Allergens.HALAL)
        ),
        FoodDishEntity(
            id = 12,
            restaurantId = 8,
            name = "Sweet Potato Curry",
            imageResId = R.drawable.meal_6,
            price = 15.00,
            description = "A warming coconut milk curry with sweet potatoes, spinach, and aromatic spices. This dish is entirely plant-based and perfect for a healthy lunch.",
            cookingTime = "20 min",
            servingSize = "Medium",
            calories = "390 kcal",
            allergens = listOf(Allergens.VEGAN, Allergens.VEGETARIAN, Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 13,
            restaurantId = 4,
            name = "Rustic Pizza",
            imageResId = R.drawable.meal_1,
            price = 14.00,
            description = "Thin-crust pizza topped with local smoked beef, mushrooms, and fresh mozzarella. Baked in a traditional wood-fired oven for a smoky finish.",
            cookingTime = "15 min",
            servingSize = "Large",
            calories = "950 kcal",
            allergens = listOf(Allergens.HALAL)
        ),
        FoodDishEntity(
            id = 14,
            restaurantId = 6,
            name = "Duck Confit",
            imageResId = R.drawable.meal_2,
            price = 38.00,
            description = "Classic French-style duck leg slow-cooked in its own fat until tender and crispy. Served with a side of mashed potatoes and red wine reduction.",
            cookingTime = "40 min",
            servingSize = "Medium",
            calories = "820 kcal",
            allergens = listOf(Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 15,
            restaurantId = 5,
            name = "Sudžukice in Somun",
            imageResId = R.drawable.meal_3,
            price = 10.00,
            description = "Spicy Bosnian sausages grilled over hot coals and tucked into a warm somun bread. A favorite quick bite for locals wandering through Baščaršija.",
            cookingTime = "10 min",
            servingSize = "5 pieces",
            calories = "710 kcal",
            allergens = listOf(Allergens.HALAL, Allergens.LACTOSE_FREE)
        ),
        FoodDishEntity(
            id = 16,
            restaurantId = 9,
            name = "Bosanski Lonac",
            imageResId = R.drawable.meal_4,
            price = 18.00,
            description = "A hearty stew featuring layers of meat and various vegetables slow-cooked for hours. It represents the historical soul of Bosnian communal dining.",
            cookingTime = "60 min",
            servingSize = "Large",
            calories = "600 kcal",
            allergens = listOf(Allergens.HALAL, Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 17,
            restaurantId = 2,
            name = "Japrak",
            imageResId = R.drawable.meal_5,
            price = 15.00,
            description = "Minced meat and rice wrapped in vine leaves, typical for the Herzegovina region. These small rolls are packed with flavor and served with sour cream.",
            cookingTime = "30 min",
            servingSize = "6 pieces",
            calories = "430 kcal",
            allergens = listOf(Allergens.HALAL, Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 18,
            restaurantId = 3,
            name = "Mushroom Risotto",
            imageResId = R.drawable.meal_6,
            price = 17.50,
            description = "Creamy Arborio rice cooked with a variety of forest mushrooms and finished with parmesan cheese. It offers a rich, earthy flavor and a silky texture.",
            cookingTime = "25 min",
            servingSize = "Medium",
            calories = "520 kcal",
            allergens = listOf(Allergens.VEGETARIAN, Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 19,
            restaurantId = 10,
            name = "Lamb Chops",
            imageResId = R.drawable.meal_1,
            price = 36.00,
            description = "Succulent lamb chops marinated in garlic and rosemary, then grilled to your preference. Served with a side of mint jelly and roasted root vegetables.",
            cookingTime = "25 min",
            servingSize = "Regular",
            calories = "780 kcal",
            allergens = listOf(Allergens.HALAL, Allergens.GLUTEN_FREE)
        ),
        FoodDishEntity(
            id = 20,
            restaurantId = 7,
            name = "Baklava Duo",
            imageResId = R.drawable.meal_2,
            price = 7.00,
            description = "A pair of traditional walnut-filled pastries drenched in sweet sugar syrup. The perfect sugary end to a rich Bosnian meal.",
            cookingTime = "5 min",
            servingSize = "Small",
            calories = "550 kcal",
            allergens = listOf(Allergens.VEGETARIAN)
        )
    )
}