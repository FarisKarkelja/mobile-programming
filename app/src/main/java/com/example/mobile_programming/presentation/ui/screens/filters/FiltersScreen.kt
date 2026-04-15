package com.example.mobile_programming.presentation.ui.screens.filters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.filters.components.FilterDropdownMenu
import kotlin.math.roundToInt
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.ui.components.ApplicationLogo

@Composable
fun FiltersScreen(
    categoryId: String,
    onNavigateToRestaurants: (String, String, String, Float) -> Unit
) {
    val locations = HardcodedData.locations
    val budgets = HardcodedData.budgets

    var selectedLocation by remember { mutableStateOf(HardcodedData.locations.first()) }
    var selectedBudget by remember { mutableStateOf(HardcodedData.budgets.first()) }
    var sliderPosition by remember { mutableFloatStateOf(3f) }

    val isApplyEnabled = selectedLocation != "Location" && selectedBudget != "Budget"

    val onApplyClick: () -> Unit = {
        onNavigateToRestaurants(categoryId, selectedLocation, selectedBudget, sliderPosition)
    }

    FiltersScreen(
        locations = locations,
        budgets = budgets,
        selectedLocation = selectedLocation,
        onLocationChange = { selectedLocation = it },
        selectedBudget = selectedBudget,
        onBudgetChange = { selectedBudget = it },
        sliderPosition = sliderPosition,
        onSliderChange = { sliderPosition = it },
        isApplyEnabled = isApplyEnabled,
        onApplyClick = onApplyClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FiltersScreen(
    locations: List<String>,
    budgets: List<String>,
    selectedLocation: String,
    onLocationChange: (String) -> Unit,
    selectedBudget: String,
    onBudgetChange: (String) -> Unit,
    sliderPosition: Float,
    onSliderChange: (Float) -> Unit,
    isApplyEnabled: Boolean,
    onApplyClick: () -> Unit
) {
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
            ApplicationLogo()
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
                onOptionSelected = onLocationChange
            )

            FilterDropdownMenu(
                label = "Budget",
                options = budgets,
                selectedOption = selectedBudget,
                onOptionSelected = onBudgetChange
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
                    onValueChange = onSliderChange,
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
            onClick = onApplyClick,
            enabled = isApplyEnabled,
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
                stringResource(id = R.string.apply_and_continue),
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8)),
                color = WarmCream
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFiltersScreen() {
    FiltersScreen(
        locations = listOf("Sample Location"),
        budgets = listOf("Sample Budget"),
        selectedLocation = "Location",
        onLocationChange = {},
        selectedBudget = "Budget",
        onBudgetChange = {},
        sliderPosition = 3f,
        onSliderChange = {},
        isApplyEnabled = false,
        onApplyClick = {}
    )
}