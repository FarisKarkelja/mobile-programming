package com.example.mobile_programming.presentation.ui.screens.categories.util

fun formatCategories(categories: List<Category>, pattern: List<Int>): List<List<Category>> {
    var currentIndex = 0
    val formattedList = mutableListOf<List<Category>>()

    for (countInRow in pattern) {
        val rowList = mutableListOf<Category>()
        for (i in 0 until countInRow) {
            if (currentIndex < categories.size) {
                rowList.add(categories[currentIndex])
                currentIndex++
            }
        }
        if (rowList.isNotEmpty()) {
            formattedList.add(rowList)
        }
    }
    return formattedList
}