package com.example.mobile_programming.presentation.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("login_screen")
    data object Registration : Screen("registration_screen")
    data object Categories : Screen("categories_screen")
    data object Filters : Screen("filters_screen/{categoryId}") {
        fun createRoute(categoryId: String): String {
            return "filters_screen/$categoryId"
        }
    }

    data object Restaurants :
        Screen("restaurants_screen/{categoryId}/{location}/{budget}/{minRating}") {
        fun createRoute(
            categoryId: String,
            location: String,
            budget: String,
            minRating: Float
        ): String {
            return "restaurants_screen/$categoryId/$location/$budget/$minRating"
        }
    }

    data object RestaurantDetails : Screen("restaurant_details_screen/{restaurantId}") {
        fun createRoute(restaurantId: String): String {
            return "restaurant_details_screen/$restaurantId"
        }
    }

    data object FavoriteRestaurants : Screen("favorite_restaurants_screen")
    data object Profile : Screen("profile_screen")

    companion object {
        fun getBottomBarNavigationRoutes(): List<String> {
            return listOf(
                Restaurants.route,
                FavoriteRestaurants.route,
                Profile.route
            )
        }
    }
}