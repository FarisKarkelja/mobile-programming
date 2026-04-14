package com.example.mobile_programming.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobile_programming.presentation.ui.screens.categories.CategoriesScreen
import com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.FavoriteRestaurantsScreen
import com.example.mobile_programming.presentation.ui.screens.filters.FiltersScreen
import com.example.mobile_programming.presentation.ui.screens.login.LoginScreen
import com.example.mobile_programming.presentation.ui.screens.profile.ProfileScreen
import com.example.mobile_programming.presentation.ui.screens.registration.RegistrationScreen
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.RestaurantDetailsScreen
import com.example.mobile_programming.presentation.ui.screens.restaurants.RestaurantsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen()
        }

        composable(route = Screen.Registration.route) {
            RegistrationScreen()
        }

        composable(route = Screen.Categories.route) {
            CategoriesScreen()
        }

        composable(route = Screen.Filters.route) {
            FiltersScreen()
        }

        composable(route = Screen.Restaurants.route) {
            RestaurantsScreen()
        }

        composable(route = Screen.RestaurantDetails.route) {
            RestaurantDetailsScreen()
        }

        composable(route = Screen.FavoriteRestaurants.route) {
            FavoriteRestaurantsScreen()
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
    }
}

