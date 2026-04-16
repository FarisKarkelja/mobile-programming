package com.example.mobile_programming.presentation.ui.screens.food_dish_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.drink_details.components.DetailBadge
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.components.InfoTag
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.ALLERGENS
import com.example.mobile_programming.presentation.ui.screens.food_dish_details.util.FoodDish

@Composable
fun FoodDishDetailsScreen(
    dishId: String,
    onBackClick: () -> Unit
) {
    val dish = HardcodedData.foodDishes.find { it.id == dishId }

    FoodDishDetailsScreen(
        dish = dish,
        onBackClick = onBackClick
    )
}

@Composable
private fun FoodDishDetailsScreen(
    dish: FoodDish?,
    onBackClick: () -> Unit
) {
    if (dish == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = stringResource(R.string.food_dish_not_found))
        }
    } else {
        Scaffold(
            topBar = {
                TopBar(
                    title = stringResource(id = R.string.food_dish),
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
                    painter = painterResource(id = dish.imageResId),
                    contentDescription = dish.name,
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
                        text = dish.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "${dish.price} BAM",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary
                    )
                }

                VerticalSpace(height = dimensionResource(R.dimen.height_12))
                Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_8))) {
                    val allergenLabel = when (dish.allergens) {
                        ALLERGENS.GLUTEN_FREE -> "Gluten Free"
                        ALLERGENS.LACTOSE_FREE -> "Lactose Free"
                        ALLERGENS.VEGETARIAN -> "Vegetarian"
                    }
                    DetailBadge(text = allergenLabel)
                }

                VerticalSpace(height = dimensionResource(R.dimen.height_24))
                Row(modifier = Modifier.fillMaxWidth()) {
                    InfoTag(label = "Cooking Time", value = dish.cookingTime)
                    InfoTag(label = "Serving Size", value = dish.servingSize)
                    InfoTag(label = "Calories", value = dish.calories)
                }

                VerticalSpace(height = dimensionResource(R.dimen.height_24))
                HorizontalDivider(
                    thickness = dimensionResource(R.dimen.thickness_half),
                    color = TextPrimary.copy(alpha = 0.1f)
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                Text(
                    text = stringResource(R.string.about_dish),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_8))
                Text(
                    text = dish.description,
                    fontSize = 15.sp,
                    color = TextPrimary.copy(alpha = 0.7f),
                    lineHeight = 22.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodDishDetailsPreview() {
    val sampleDish = HardcodedData.foodDishes[0]

    FoodDishDetailsScreen(
        dish = sampleDish,
        onBackClick = {}
    )
}