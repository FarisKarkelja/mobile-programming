package com.example.mobile_programming.presentation.ui.screens.filters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.filters.components.FilterDropdownMenu
import kotlin.math.roundToInt
import com.example.mobile_programming.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersScreen() {
    val locations = listOf(
        "Dobrinja", "Nedžarići", "Alipašino Polje", "Otoka",
        "Čengić Vila", "Malta", "Pofalići", "Marijin Dvor",
        "Skenderija", "Baščaršija", "Vijećnica"
    )
    val budgets = listOf("Under 20 BAM", "20 - 50 BAM", "50 - 100 BAM", "100+ BAM")

    var selectedLocation by remember { mutableStateOf("Location") }
    var selectedBudget by remember { mutableStateOf("Budget") }
    var sliderPosition by remember { mutableFloatStateOf(3f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WarmCream)
            .padding(dimensionResource(id = R.dimen.padding_16))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.height_200))
                .align(Alignment.TopCenter),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(dimensionResource(id = R.dimen.size_420))
            )
        }

        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_20)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FilterDropdownMenu(
                label = "Location",
                options = locations,
                selectedOption = selectedLocation,
                onOptionSelected = { selectedLocation = it }
            )

            FilterDropdownMenu(
                label = "Budget",
                options = budgets,
                selectedOption = selectedBudget,
                onOptionSelected = { selectedBudget = it }
            )

            VerticalSpace(dimensionResource(id = R.dimen.height_8))
            Column(
                modifier = Modifier.fillMaxWidth(0.7f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Minimum Rating: ${sliderPosition.roundToInt()}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextPrimary
                )
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    valueRange = 1f..5f,
                    steps = 3,
                    colors = SliderDefaults.colors(
                        thumbColor = SunsetTangerine,
                        activeTrackColor = SunsetTangerine,
                        inactiveTrackColor = SunsetTangerine.copy(alpha = 0.2f),
                        activeTickColor = White,
                        inactiveTickColor = SunsetTangerine
                    )
                )
            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = dimensionResource(id = R.dimen.padding_8)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
            colors = ButtonDefaults.buttonColors(
                containerColor = SunsetTangerine,
                contentColor = Color.White
            )
        ) {
            Text(
                "Apply and Continue",
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8)),
                color = WarmCream
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFiltersScreen() {
    FiltersScreen()
}