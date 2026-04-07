package com.example.mobile_programming.presentation.ui.screens.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.ApplicationLogo
import com.example.mobile_programming.presentation.ui.screens.categories.components.CategoryCircle
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category

@Composable
fun CategoriesScreen() {
    var categories by remember { mutableStateOf(HardcodedData.categories) }

    val onCategoryClick: (String) -> Unit = { id ->
        // TODO: onCategoryClick logic
    }

    CategoriesScreen(
        categories = categories,
        onCategoryClick = onCategoryClick
    )
}

@Composable
private fun CategoriesScreen(
    categories: List<Category>,
    onCategoryClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WarmCream)
            .padding(dimensionResource(id = R.dimen.padding_16)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.height_200)),
            contentAlignment = Alignment.Center
        ) {
            ApplicationLogo()
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(
                title = stringResource(R.string.local_title),
                iconResource = R.drawable.bosnia
            )
        }
        VerticalSpace()
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(
                stringResource(R.string.quick_title),
                iconResource = R.drawable.kebab
            )
            HorizontalSpace()
            CategoryCircle(
                stringResource(R.string.bbq_title),
                iconResource = R.drawable.steak
            )
            HorizontalSpace()
            CategoryCircle(
                stringResource(R.string.pie_title),
                iconResource = R.drawable.pie
            )
        }
        VerticalSpace()
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(stringResource(R.string.healthy_title), iconResource = R.drawable.salad)
            HorizontalSpace()
            CategoryCircle(
                stringResource(R.string.global_title),
                iconResource = R.drawable.worldwide
            )
        }
        VerticalSpace()
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            CategoryCircle(stringResource(R.string.sweets_title), iconResource = R.drawable.cake)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoriesScreen() {
    CategoriesScreen()
}
