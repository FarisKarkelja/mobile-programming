package com.example.mobile_programming.presentation.view_model.drink_details

sealed interface DrinkDetailsNavigationEvent {
    object Navigate : DrinkDetailsNavigationEvent
    object NavigateBack : DrinkDetailsNavigationEvent
}