package com.example.mobile_programming.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import com.example.mobile_programming.presentation.ui.util.InfoRowData

@Composable
fun InfoSection(
    title: String,
    rows: List<InfoRowData>,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            rows.forEach { row ->

                InfoRow(
                    title = row.title,
                    additionalInfo = row.additionalInfo,
                    imageVector = row.imageVector
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoSectionPreview() {

    val rows = listOf(
        InfoRowData("Study Kotlin", imageVector = Icons.Default.Star),
        InfoRowData("Workout", imageVector = Icons.Default.Star)
    )

    MaterialTheme {
        InfoSection(
            title = "Today's Quests",
            rows = rows
        )
    }
}
