package com.example.mobile_programming.model.data.local.util

import com.example.mobile_programming.R
import com.example.mobile_programming.model.data.local.entity.DrinkEntity

object DrinkSeed {
    val defaultDrinks = listOf(
        DrinkEntity(
            id = 1,
            restaurantId = 1,
            name = "Bosnian Coffee",
            imageResId = R.drawable.drink_1,
            price = 4.00,
            description = "Strong, unfiltered coffee served in a traditional copper dzezva with a sugar cube and Turkish delight. It is the heart of Sarajevo's social ritual.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 2,
            restaurantId = 5,
            name = "Cold Ayran",
            imageResId = R.drawable.drink_2,
            price = 3.00,
            description = "A refreshing, salty yogurt-based drink that perfectly complements grilled meats. It is served chilled and helps with digestion after a heavy meal.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 3,
            restaurantId = 7,
            name = "Elderberry Juice",
            imageResId = R.drawable.drink_3,
            price = 4.50,
            description = "Homemade syrup made from elderberry flowers collected from the Bosnian mountains. It is a sweet, floral, and nostalgic drink for many locals.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 4,
            restaurantId = 10,
            name = "Sarajevsko Beer",
            imageResId = R.drawable.drink_4,
            price = 5.00,
            description = "The iconic local lager brewed in the heart of the city since 1864. It has a crisp, refreshing taste that pairs well with any dish.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 5,
            restaurantId = 6,
            name = "Chardonnay",
            imageResId = R.drawable.drink_5,
            price = 9.00,
            description = "A glass of premium dry white wine with notes of apple and citrus. Perfectly chilled to accompany seafood or creamy pasta dishes.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 6,
            restaurantId = 3,
            name = "Virgin Mojito",
            imageResId = R.drawable.drink_6,
            price = 7.50,
            description = "A refreshing mocktail made with fresh lime juice, crushed mint, and sparkling water. It is a perfect non-alcoholic choice for a hot summer day.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 7,
            restaurantId = 8,
            name = "Green Detox Juice",
            imageResId = R.drawable.drink_1,
            price = 8.50,
            description = "A cold-pressed blend of spinach, green apple, cucumber, and ginger. This nutrient-packed drink is designed to boost your energy naturally.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 8,
            restaurantId = 2,
            name = "Turkish Tea",
            imageResId = R.drawable.drink_2,
            price = 3.50,
            description = "Traditional black tea served in small tulip-shaped glasses. It is a staple in Baščaršija for those who enjoy a long conversation.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 9,
            restaurantId = 4,
            name = "Hot Chocolate",
            imageResId = R.drawable.drink_3,
            price = 5.50,
            description = "Rich and thick dark chocolate topped with a mountain of whipped cream. A favorite treat during the snowy winter months in Sarajevo.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 10,
            restaurantId = 9,
            name = "Rose Sherbet",
            imageResId = R.drawable.drink_4,
            price = 4.00,
            description = "A traditional Ottoman-era drink made from rose petals and sugar. It is incredibly fragrant and offers a unique taste of history.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 11,
            restaurantId = 1,
            name = "Rakija (Plum)",
            imageResId = R.drawable.drink_5,
            price = 5.00,
            description = "A potent traditional fruit brandy made from fermented plums. Usually served as an aperitif to kickstart your appetite.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 12,
            restaurantId = 6,
            name = "Espresso Martini",
            imageResId = R.drawable.drink_6,
            price = 12.00,
            description = "A sophisticated cocktail combining premium vodka with a fresh shot of espresso. It is the perfect pick-me-up for a night out in the city.",
            isAlcoholic = true,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 13,
            restaurantId = 5,
            name = "Sparkling Water",
            imageResId = R.drawable.drink_1,
            price = 3.00,
            description = "Refreshing mineral water sourced from local springs. A simple and essential accompaniment to any cup of Bosnian coffee.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 14,
            restaurantId = 7,
            name = "Blueberry Smoothie",
            imageResId = R.drawable.drink_2,
            price = 7.00,
            description = "Blended wild blueberries from the Olympic mountains mixed with yogurt and a hint of honey. It is thick, sweet, and full of antioxidants.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 15,
            restaurantId = 3,
            name = "Cabernet Sauvignon",
            imageResId = R.drawable.drink_3,
            price = 10.00,
            description = "A full-bodied red wine with deep flavors of blackcurrant and oak. Ideal for pairing with grilled steaks or aged cheeses.",
            isAlcoholic = true,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 16,
            restaurantId = 8,
            name = "Iced Matcha Latte",
            imageResId = R.drawable.drink_4,
            price = 6.50,
            description = "Ceremonial grade matcha whisked with cold almond milk and a touch of agave. A trendy and healthy alternative for caffeine lovers.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 17,
            restaurantId = 10,
            name = "Old Fashioned",
            imageResId = R.drawable.drink_5,
            price = 11.00,
            description = "A classic gentleman's cocktail made with bourbon, bitters, and a twist of citrus peel. Slow-sipped and full of character.",
            isAlcoholic = true,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 18,
            restaurantId = 4,
            name = "Lemonade with Ginger",
            imageResId = R.drawable.drink_6,
            price = 5.00,
            description = "Freshly squeezed lemons mixed with spicy ginger root and honey. A powerful drink that is both refreshing and immune-boosting.",
            isAlcoholic = false,
            isSugarFree = false
        ),
        DrinkEntity(
            id = 19,
            restaurantId = 9,
            name = "Earl Grey Tea",
            imageResId = R.drawable.drink_1,
            price = 4.00,
            description = "Fine black tea scented with oil of bergamot, served with a side of milk or lemon. A classic choice for a quiet afternoon.",
            isAlcoholic = false,
            isSugarFree = true
        ),
        DrinkEntity(
            id = 20,
            restaurantId = 2,
            name = "Pomegranate Juice",
            imageResId = R.drawable.drink_2,
            price = 6.00,
            description = "Freshly pressed pomegranate juice, tart and sweet at the same time. This vibrant red drink is as healthy as it is delicious.",
            isAlcoholic = false,
            isSugarFree = false
        )
    )
}