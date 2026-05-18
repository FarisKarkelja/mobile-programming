package com.example.mobile_programming.presentation.view_model.filters

sealed interface FilterNavigationEvent {
    object Navigate : FilterNavigationEvent
    object NavigateBack : FilterNavigationEvent
}