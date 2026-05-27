package com.example.mobile_programming.presentation.view_model.restaurant_details

sealed interface RestaurantDetailsUiEvent {
    data class ShowToast(val message: String) : RestaurantDetailsUiEvent
}