package com.example.mobile_programming.presentation.view_model.restaurant_details

sealed interface RestaurantDetailsNavigationEvent {
    object Navigate : RestaurantDetailsNavigationEvent
    object NavigateBack : RestaurantDetailsNavigationEvent
}