package com.example.mobile_programming.presentation.ui.screens.drink_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.drink_details.components.DetailBadge
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.drink_details.util.Drink

@Composable
fun DrinkDetailsScreen(
    drinkId: String,
    onBackClick: () -> Unit
) {
    val drink = HardcodedData.drinks.find { it.id == drinkId }

    DrinkDetailsScreen(
        drink = drink,
        onBackClick = onBackClick
    )
}

@Composable
private fun DrinkDetailsScreen(
    drink: Drink?,
    onBackClick: () -> Unit
) {
    if (drink == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = stringResource(R.string.drink_not_found))
        }
    } else {
        Scaffold(
            topBar = {
                TopBar(
                    title = stringResource(id = R.string.drink),
                    onBackClick = onBackClick
                )
            },
            containerColor = WarmCream
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(dimensionResource(id = R.dimen.padding_16))
            ) {
                Image(
                    painter = painterResource(id = drink.imageResId),
                    contentDescription = drink.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.height_250))
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))),
                    contentScale = ContentScale.Crop
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = drink.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "${drink.price} BAM",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary
                    )
                }

                VerticalSpace(height = dimensionResource(R.dimen.height_12))
                Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.height_8))) {
                    DetailBadge(text = "Freshly Prepared")
                    DetailBadge(text = "Premium Quality")
                }

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                androidx.compose.material3.HorizontalDivider(
                    thickness = dimensionResource(R.dimen.thickness_half),
                    color = TextPrimary.copy(alpha = 0.1f)
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                Text(
                    text = stringResource(R.string.about_drink),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_8))
                Text(
                    text = drink.description,
                    fontSize = 15.sp,
                    color = TextPrimary.copy(alpha = 0.7f),
                    lineHeight = 22.sp,
                )
            }
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun DrinkDetailsPreview() {
    val sampleDrink = HardcodedData.drinks[0]

    DrinkDetailsScreen(
        drink = sampleDrink,
        onBackClick = {}
    )
}