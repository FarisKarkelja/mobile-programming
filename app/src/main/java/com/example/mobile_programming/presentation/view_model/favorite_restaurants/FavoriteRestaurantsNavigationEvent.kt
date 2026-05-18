package com.example.mobile_programming.presentation.view_model.favorite_restaurants

sealed interface FavoriteRestaurantsNavigationEvent {
    object Navigate : FavoriteRestaurantsNavigationEvent
    object NavigateBack : FavoriteRestaurantsNavigationEvent
}