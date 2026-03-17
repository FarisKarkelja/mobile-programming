package com.example.mobile_programming.presentation.ui.screens.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.screens.categories.components.CategoryCircle
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.VerticalSpace

@Composable
fun CategoriesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WarmCream)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier.size(420.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(title = "Local", iconResource = R.drawable.bosnia)
        }
        VerticalSpace()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(
                title = "Quick",
                iconResource = R.drawable.kebab
            )
            HorizontalSpace()
            CategoryCircle(
                title = "BBQ",
                iconResource = R.drawable.steak
            )
            HorizontalSpace()
            CategoryCircle(
                title = "Pie",
                iconResource = R.drawable.pie
            )
        }
        VerticalSpace()
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(title = "Healthy", iconResource = R.drawable.salad)
            HorizontalSpace()
            CategoryCircle(title = "Global", iconResource = R.drawable.worldwide)
        }
        VerticalSpace()
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(title = "Sweets", iconResource = R.drawable.cake)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoriesScreen() {
    CategoriesScreen()
}
