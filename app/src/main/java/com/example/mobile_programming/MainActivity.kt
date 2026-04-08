package com.example.mobile_programming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mobile_programming.presentation.theme.MobileprogrammingTheme
import com.example.mobile_programming.presentation.ui.screens.categories.CategoriesScreen
import com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.FavoriteRestaurantsScreen
import com.example.mobile_programming.presentation.ui.screens.filters.FiltersScreen
import com.example.mobile_programming.presentation.ui.screens.login.LoginScreen
import com.example.mobile_programming.presentation.ui.screens.profile.ProfileScreen
import com.example.mobile_programming.presentation.ui.screens.registration.RegistrationScreen
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.RestaurantDetailsScreen
import com.example.mobile_programming.presentation.ui.screens.restaurants.RestaurantsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileprogrammingTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CategoriesScreen()
                }
            }
        }
    }
}


