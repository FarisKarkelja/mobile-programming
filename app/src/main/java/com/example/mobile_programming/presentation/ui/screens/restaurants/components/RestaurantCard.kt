package com.example.mobile_programming.presentation.ui.screens.restaurants.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.Gold
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.VerticalSpace

@Composable
fun RestaurantCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_8)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .background(SunsetTangerine)
                .padding(dimensionResource(id = R.dimen.padding_10))
        ) {
            Image(
                painter = painterResource(id = R.drawable.restaurant_placeholder),
                contentDescription = "Restaurant Image",
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
                    Text(
                        text = stringResource(R.string.restaurant_title),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                    VerticalSpace(dimensionResource(id = R.dimen.height_2))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Restaurant Location",
                            tint = White,
                            modifier = Modifier.size(dimensionResource(id = R.dimen.size_18))
                        )

                        HorizontalSpace(dimensionResource(id = R.dimen.width_4))
                        Text(
                            text = stringResource(R.string.restaurant_location),
                            fontSize = 12.sp,
                            color = White
                        )
                    }
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
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Restaurant Rating",
                        tint = Gold,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.size_16))
                    )

                    HorizontalSpace(dimensionResource(id = R.dimen.width_4))
                    Text(
                        text = stringResource(R.string.restaurant_rating),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }

                Row(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { /* TODO: Add favorite logic */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = WarmCream,
                            modifier = Modifier.size(dimensionResource(id = R.dimen.size_24))
                        )
                    }

                    IconButton(
                        onClick = { /* TODO: Add redirection logic */ }
                    ) {
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