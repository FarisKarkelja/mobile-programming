package com.example.mobile_programming.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Categories.route)
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Registration.route)
                }
            )
        }

        composable(route = Screen.Registration.route) {
            RegistrationScreen(
                onRegisterSuccess = {
                    navController.navigate(Screen.Login.route)
                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        composable(route = Screen.Categories.route) {
            CategoriesScreen(
                onNavigateToFilters = { categoryId ->
                    navController.navigate(Screen.Filters.createRoute(categoryId))
                }
            )
        }

        composable(
            route = Screen.Filters.route,
            arguments = listOf(
                navArgument("categoryId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId").orEmpty()

            FiltersScreen(
                categoryId = categoryId,
                onNavigateToRestaurants = { selectedCategoryId, location, budget, rating ->
                    navController.navigate(
                        Screen.Restaurants.createRoute(selectedCategoryId, location, budget, rating)
                    )
                }
            )
        }

        composable(
            route = Screen.Restaurants.route,
            arguments = listOf(
                navArgument("categoryId") { type = NavType.StringType },
                navArgument("location") { type = NavType.StringType },
                navArgument("budget") { type = NavType.StringType },
                navArgument("minRating") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId").orEmpty()
            val location = backStackEntry.arguments?.getString("location").orEmpty()
            val budget = backStackEntry.arguments?.getString("budget").orEmpty()
            val minRating = backStackEntry.arguments?.getFloat("minRating") ?: 3.0f

            RestaurantsScreen(
                categoryId = categoryId,
                location = location,
                budget = budget,
                minRating = minRating,
                onNavigateToDetails = { restaurantId ->
                    navController.navigate(Screen.RestaurantDetails.createRoute(restaurantId))
                }
            )
        }

        composable(
            route = Screen.RestaurantDetails.route,
            arguments = listOf(
                navArgument("restaurantId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId").orEmpty()
            RestaurantDetailsScreen(restaurantId = restaurantId)
        }

        composable(route = Screen.FavoriteRestaurants.route) {
            FavoriteRestaurantsScreen(
                onNavigateToDetails = { restaurantId ->
                    navController.navigate(Screen.RestaurantDetails.createRoute(restaurantId))
                }
            )
        }

        composable(route = Screen.Profile.route) {
            ProfileScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
    }
}

