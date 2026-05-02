package com.example.mobile_programming.presentation.view_model.restaurants

sealed interface RestaurantNavigationEvent {
    object Navigate : RestaurantNavigationEvent
    object NavigateBack : RestaurantNavigationEvent
}