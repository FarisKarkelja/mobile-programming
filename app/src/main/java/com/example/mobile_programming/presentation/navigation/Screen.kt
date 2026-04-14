package com.example.mobile_programming.presentation.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("login_screen")
    data object Registration : Screen("registration_screen")
    data object Categories : Screen("categories_screen")
    data object Filters : Screen("filters_screen")
    data object Restaurants : Screen("restaurants_screen")
    data object RestaurantDetails : Screen("restaurant_details_screen")
    data object FavoriteRestaurants : Screen("favorite_restaurants_screen")
    data object Profile : Screen("profile_screen")
}