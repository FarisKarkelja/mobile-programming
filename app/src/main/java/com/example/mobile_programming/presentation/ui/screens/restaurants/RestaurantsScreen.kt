package com.example.mobile_programming.presentation.ui.screens.restaurants

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.presentation.ui.components.*
import com.example.mobile_programming.presentation.ui.util.InfoRowData

@Composable
fun RestaurantsScreen() {

    val quests = listOf(
        InfoRowData("Study Kotlin", imageVector = Icons.Default.Star),
        InfoRowData("Workout", imageVector = Icons.Default.Star),
        InfoRowData("Drink Water", imageVector = Icons.Default.Star)
    )

    val achievements = listOf(
        InfoRowData("First Quest", imageVector = Icons.Default.Face),
        InfoRowData("3 Day Streak", imageVector = Icons.Default.Face)
    )

    val stats = listOf(
        InfoRowData("Quests Completed", "5"),
        InfoRowData("Total XP", "120"),
        InfoRowData("Achievements", "3")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Title(title = "LifeRPG")

        Spacer(modifier = Modifier.height(16.dp))

        UserSectionCard(
            levelNo = 3,
            achievementLevel = "Adventurer",
            currentXP = 120,
            maxXP = 200
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = "Today's Quests",
            rows = quests
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = "Achievements",
            rows = achievements
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoSection(
            title = "Quick Stats",
            rows = stats
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RestaurantsScreenPreview() {
    MaterialTheme {
        RestaurantsScreen()
    }
}
