package com.example.mobile_programming.presentation.ui.screens.favorite_restaurants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.components.FavoriteRestaurantCard

@Composable
fun FavoriteRestaurantsScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = WarmCream
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 8.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(10) {
                FavoriteRestaurantCard()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFavoriteRestaurantsScreen() {
    FavoriteRestaurantsScreen()
}