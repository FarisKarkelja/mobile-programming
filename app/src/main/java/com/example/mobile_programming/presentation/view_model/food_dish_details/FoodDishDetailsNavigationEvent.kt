package com.example.mobile_programming.presentation.view_model.food_dish_details

sealed interface FoodDishDetailsNavigationEvent {
    object Navigate : FoodDishDetailsNavigationEvent
    object NavigateBack : FoodDishDetailsNavigationEvent
}