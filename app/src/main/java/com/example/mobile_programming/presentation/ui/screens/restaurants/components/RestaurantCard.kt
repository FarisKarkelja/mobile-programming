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
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .background(SunsetTangerine)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.restaurant_placeholder),
                contentDescription = "Restaurant Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            HorizontalSpace()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
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
                    VerticalSpace(2.dp)

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Restaurant Location",
                            tint = White,
                            modifier = Modifier.size(18.dp)
                        )

                        HorizontalSpace(4.dp)
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
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp),
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
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(
                        onClick = { /* TODO: Add redirection logic */ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Details",
                            tint = WarmCream,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}