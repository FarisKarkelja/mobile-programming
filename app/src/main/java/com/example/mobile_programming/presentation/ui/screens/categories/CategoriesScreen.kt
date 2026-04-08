package com.example.mobile_programming.presentation.ui.screens.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.R
import com.example.mobile_programming.data.HardcodedData
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.ApplicationLogo
import com.example.mobile_programming.presentation.ui.screens.categories.components.CategoryCircle
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.categories.util.formatCategories

@Composable
fun CategoriesScreen() {
    var categories by remember { mutableStateOf(HardcodedData.categories) }

    val rowPattern = listOf(1, 3, 2, 1)
    val formattedCategories by remember(categories) {
        derivedStateOf { formatCategories(categories, rowPattern) }
    }

    val onCategoryClick: (String) -> Unit = { id ->
        // TODO: onCategoryClick logic
    }

    CategoriesScreen(
        categories = formattedCategories,
        onCategoryClick = onCategoryClick
    )
}

@Composable
private fun CategoriesScreen(
    categories: List<List<Category>>,
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

        categories.forEach { rowOfCategories ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                rowOfCategories.forEachIndexed { index, category ->
                    CategoryCircle(
                        title = category.name,
                        iconResource = category.iconResId,
                        onClick = { onCategoryClick(category.id) }
                    )
                    if (index < rowOfCategories.size - 1) {
                        HorizontalSpace()
                    }
                }
            }
            VerticalSpace()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoriesScreen() {
    CategoriesScreen()
}
