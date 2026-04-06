package com.example.mobile_programming.presentation.ui.screens.restaurants.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.RestaurantLocation
import com.example.mobile_programming.presentation.ui.components.RestaurantRating
import com.example.mobile_programming.presentation.ui.components.RestaurantTitle
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.restaurants.util.Restaurant

@Composable
fun RestaurantCard(
    restaurant: Restaurant,
    onFavoriteClick: () -> Unit,
    onDetailsClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_8)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.elevation_8))
    ) {
        Row(
            modifier = Modifier
                .background(SunsetTangerine)
                .padding(dimensionResource(id = R.dimen.padding_10))
        ) {
            Image(
                painter = painterResource(id = restaurant.imageResId),
                contentDescription = restaurant.name,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.size_100))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))),
                contentScale = ContentScale.Crop
            )

            HorizontalSpace()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.height_100))
            ) {
                Column(
                    modifier = Modifier.align(Alignment.TopStart)
                ) {
                    RestaurantTitle(title = restaurant.name, fontSize = 18.sp, color = White)
                    VerticalSpace(dimensionResource(id = R.dimen.height_2))
                    RestaurantLocation(location = restaurant.location)
                }

                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .background(
                            WarmCream,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))
                        )
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.padding_8),
                            vertical = dimensionResource(id = R.dimen.padding_2)
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RestaurantRating(rating = restaurant.rating, fontSize = 12.sp)
                }

                Row(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onFavoriteClick) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = WarmCream,
                            modifier = Modifier.size(dimensionResource(id = R.dimen.size_24))
                        )
                    }

                    IconButton(onClick = onDetailsClick) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Details",
                            tint = WarmCream,
                            modifier = Modifier.size(dimensionResource(id = R.dimen.size_24))
                        )
                    }
                }
            }
        }
    }
}