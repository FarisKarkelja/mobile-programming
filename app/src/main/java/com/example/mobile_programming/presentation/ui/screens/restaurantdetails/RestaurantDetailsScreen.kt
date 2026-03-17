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
                        text = "Restaurant Name",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    VerticalSpace(2.dp)
                    Text(
                        text = "Cuisine Type • Cuisine Type",
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
                            text = "Address Street XY",
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
                        contentDescription = "Rating",
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "4.5",
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            }
            VerticalSpace(24.dp)
            RestaurantDetailsTitle("About")

            VerticalSpace(8.dp)
            Text(
                text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                fontSize = 15.sp,
                color = TextPrimary,
                lineHeight = 22.sp
            )

            VerticalSpace(24.dp)
            RestaurantDetailsTitle("Recommended")

            VerticalSpace(12.dp)
            FoodDishRow(
                name1 = "Tortilla", image1 = R.drawable.meal,
                name2 = "Burrito", image2 = R.drawable.meal,
                name3 = "Salad", image3 = R.drawable.meal
            )

            VerticalSpace(12.dp)
            FoodDishRow(
                name1 = "Tortilla", image1 = R.drawable.meal,
                name2 = "Burrito", image2 = R.drawable.meal,
                name3 = "Salad", image3 = R.drawable.meal
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