package com.example.mobile_programming.presentation.ui.screens.restaurants.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.WarmCream
import androidx.compose.material3.Icon
import com.example.mobile_programming.presentation.theme.TextPrimary

@Composable
fun RestaurantSearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.padding_8))
            .padding(
                top = dimensionResource(id = R.dimen.padding_8),
                bottom = dimensionResource(id = R.dimen.padding_4)
            ),
        placeholder = { Text(stringResource(R.string.search_restaurants), color = WarmCream) },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = stringResource(R.string.search),
                tint = WarmCream
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                Icon(
                    modifier = Modifier.clickable { onSearchQueryChange("") },
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.close),
                    tint = WarmCream
                )
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(dimensionResource(R.dimen.corner_50)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = TextPrimary,
            unfocusedContainerColor = TextPrimary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = WarmCream,
            focusedTextColor = WarmCream,
            unfocusedTextColor = WarmCream
        )
    )
}