package com.example.mobile_programming.data

data class Restaurant(
    val id: Int,
    val name: String,
    val location: String,
    val rating: Double,
    val isFavorite: Boolean = false
)

val restaurants = listOf(
    Restaurant(1, "Sunset Grill", "Downtown Sarajevo", 4.8),
    Restaurant(2, "Burger & Co.", "Baščaršija", 4.2),
    Restaurant(3, "Pasta House", "Grbavica", 4.5),
    Restaurant(4, "Sushi San", "Marijin Dvor", 4.9),
    Restaurant(5, "Vegan Vibes", "Dobrinja", 4.1),
    Restaurant(6, "Balkan Ćevapi", "Stari Grad", 4.7),
    Restaurant(7, "Pizza Nostra", "Novo Sarajevo", 4.3),
    Restaurant(8, "Wok Express", "Ilidža", 4.0),
    Restaurant(9, "Tapas Bar", "Centar", 4.6),
    Restaurant(10, "Steakhouse 99", "Vogošća", 4.8)
)