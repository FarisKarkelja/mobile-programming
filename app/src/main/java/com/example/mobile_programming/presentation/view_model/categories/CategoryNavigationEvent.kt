package com.example.mobile_programming.presentation.view_model.categories

sealed interface CategoryNavigationEvent {
    object Navigate : CategoryNavigationEvent
    object NavigateBack : CategoryNavigationEvent
}
