package com.example.mobile_programming.presentation.ui.screens.restaurantdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.*
import com.example.mobile_programming.presentation.ui.components.BottomBar
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.FoodDishRow
import com.example.mobile_programming.presentation.ui.screens.restaurantdetails.components.RestaurantDetailsTitle

@Composable
fun RestaurantDetailsScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        containerColor = WarmCream
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            VerticalSpace(16.dp)
            Image(
                painter = painterResource(id = R.drawable.restaurant_placeholder),
                contentDescription = "Restaurant Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            VerticalSpace(20.dp)
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .fillMaxWidth(0.8f)
                ) {
                    Text(
                        text = stringResource(R.string.restaurant_title),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )

                    VerticalSpace(2.dp)
                    Text(
                        text = stringResource(R.string.restaurant_cuisine),
                        fontSize = 16.sp,
                        color = Color.Gray
                    )

                    VerticalSpace(8.dp)
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Restaurant Location",
                            tint = SunsetTangerine,
                            modifier = Modifier.size(18.dp)
                        )

                        HorizontalSpace(4.dp)
                        Text(
                            text = stringResource(R.string.restaurant_location),
                            fontSize = 14.sp,
                            color = TextPrimary
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .background(
                            color = TextPrimary,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Restaurant Rating",
                        tint = Gold,
                        modifier = Modifier.size(16.dp)
                    )
                    HorizontalSpace(4.dp)
                    Text(
                        text = stringResource(R.string.restaurant_rating),
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            }
            VerticalSpace(24.dp)
            RestaurantDetailsTitle(stringResource(R.string.about_title))

            VerticalSpace(8.dp)
            Text(
                text = stringResource(R.string.restaurant_description),
                fontSize = 15.sp,
                color = TextPrimary,
                lineHeight = 22.sp
            )

            VerticalSpace(24.dp)
            RestaurantDetailsTitle(stringResource(R.string.recommended_title))

            VerticalSpace(12.dp)
            FoodDishRow(
                name1 = stringResource(R.string.pasta_title), image1 = R.drawable.meal_1,
                name2 = stringResource(R.string.salad_title), image2 = R.drawable.meal_2,
                name3 = stringResource(R.string.tortilla_title), image3 = R.drawable.meal_3
            )

            VerticalSpace(12.dp)
            FoodDishRow(
                name1 = stringResource(R.string.risotto_title), image1 = R.drawable.meal_4,
                name2 = stringResource(R.string.taco_title), image2 = R.drawable.meal_5,
                name3 = stringResource(R.string.pizza_title), image3 = R.drawable.meal_6
            )

            VerticalSpace(16.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailsScreen() {
    RestaurantDetailsScreen()
}