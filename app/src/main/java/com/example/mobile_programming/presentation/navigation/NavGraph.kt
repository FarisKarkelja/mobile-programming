package com.example.mobile_programming.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.ui.screens.categories.CategoriesScreen
import com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.FavoriteRestaurantsScreen
import com.example.mobile_programming.presentation.ui.screens.filters.FiltersScreen
import com.example.mobile_programming.presentation.ui.screens.drink_details.DrinkDetailsScreen
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.FoodDishDetailsScreen
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
    var allRestaurants by remember { mutableStateOf(HardcodedData.restaurants) }

    val onToggleFavorite: (String) -> Unit = { restaurantId ->
        allRestaurants = allRestaurants.map { restaurant ->
            if (restaurant.id == restaurantId) {
                restaurant.copy(isFavorite = !restaurant.isFavorite)
            } else {
                restaurant
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            route = Screen.Login.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Categories.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(Screen.Registration.route)
                }
            )
        }

        composable(
            route = Screen.Registration.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            RegistrationScreen(
                onRegisterSuccess = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Registration.route) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        composable(
            route = Screen.Categories.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            CategoriesScreen(
                onNavigateToFilters = { categoryId ->
                    navController.navigate(Screen.Filters.createRoute(categoryId))
                }
            )
        }

        composable(
            route = Screen.Filters.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) },
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
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) },
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
                allRestaurants = allRestaurants,
                onToggleFavorite = onToggleFavorite,
                onNavigateToDetails = { restaurantId ->
                    navController.navigate(Screen.RestaurantDetails.createRoute(restaurantId))
                }
            )
        }

        composable(
            route = Screen.RestaurantDetails.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) },
            arguments = listOf(
                navArgument("restaurantId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId").orEmpty()
            RestaurantDetailsScreen(
                restaurantId = restaurantId,
                allRestaurants = allRestaurants,
                onNavigateToDish = { dishId ->
                    navController.navigate(Screen.FoodDishDetails.createRoute(dishId))
                },
                onNavigateToDrink = { drinkId ->
                    navController.navigate(Screen.DrinkDetails.createRoute(drinkId))
                },
                onBackClick = { navController.navigateUp() })
        }

        composable(
            route = Screen.FavoriteRestaurants.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            FavoriteRestaurantsScreen(
                allRestaurants = allRestaurants,
                onToggleFavorite = onToggleFavorite,
                onNavigateToDetails = { restaurantId ->
                    navController.navigate(Screen.RestaurantDetails.createRoute(restaurantId))
                }
            )
        }

        composable(
            route = Screen.Profile.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) }
        ) {
            ProfileScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }

        composable(
            route = Screen.FoodDishDetails.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) },
            arguments = listOf(navArgument("dishId") { type = NavType.StringType })
        ) { backStackEntry ->
            val dishId = backStackEntry.arguments?.getString("dishId").orEmpty()
            FoodDishDetailsScreen(dishId = dishId, onBackClick = { navController.navigateUp() })
        }

        composable(
            route = Screen.DrinkDetails.route,
            enterTransition = { fadeIn(animationSpec = tween(300)) },
            exitTransition = { fadeOut(animationSpec = tween(300)) },
            popEnterTransition = { fadeIn(animationSpec = tween(300)) },
            popExitTransition = { fadeOut(animationSpec = tween(300)) },
            arguments = listOf(navArgument("drinkId") { type = NavType.StringType })
        ) { backStackEntry ->
            val drinkId = backStackEntry.arguments?.getString("drinkId").orEmpty()
            DrinkDetailsScreen(drinkId = drinkId, onBackClick = { navController.navigateUp() })
        }
    }
}

