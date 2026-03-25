package com.example.mobile_programming.presentation.ui.screens.favorite_restaurants.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.White

@Composable
fun FavoriteRestaurantCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
        colors = CardDefaults.cardColors(containerColor = SunsetTangerine)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.restaurant_placeholder),
                    contentDescription = "Restaurant Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                )

                Text(
                    text = stringResource(R.string.restaurant_title),
                    fontWeight = FontWeight.Bold,
                    color = White,
                    modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_8)),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = dimensionResource(id = R.dimen.padding_8),
                        top = dimensionResource(id = R.dimen.padding_8)
                    ),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* TODO: Add logic for restaurant unfavorite */ },
                    modifier = Modifier.background(
                        color = White,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Unfavorite Restaurant",
                        tint = Color.Red
                    )
                }

                IconButton(
                    onClick = { /* TODO: Add screen redirection */ },
                    modifier = Modifier.background(
                        color = White,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))
                    )
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Restaurant Details",
                        tint = TextPrimary
                    )
                }
            }
        }
    }
}