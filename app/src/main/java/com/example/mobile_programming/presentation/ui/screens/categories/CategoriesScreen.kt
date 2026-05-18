package com.example.mobile_programming.presentation.ui.screens.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobile_programming.R
import com.example.mobile_programming.model.HardcodedData
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.ApplicationLogo
import com.example.mobile_programming.presentation.ui.screens.categories.components.CategoryCircle
import com.example.mobile_programming.presentation.ui.components.HorizontalSpace
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.categories.util.Category
import com.example.mobile_programming.presentation.ui.screens.categories.util.formatCategories
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.view_model.categories.CategoryUiState
import com.example.mobile_programming.presentation.view_model.categories.CategoryViewModel

@Composable
fun CategoriesScreen(
    viewModel: CategoryViewModel,
    onNavigateToFilters: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is CategoryUiState.Loading -> LoadingScreen()
        is CategoryUiState.Error -> ErrorScreen(
            message = state.message,
            onRetry = { viewModel.resetUiState() }
        )

        is CategoryUiState.Success -> CategoriesScreen(
            categories = state.formattedCategories,
            onCategoryClick = { id -> onNavigateToFilters(id) }
        )

        else -> Unit
    }
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
    val pattern = listOf(1, 3, 2, 1)
    val preview = formatCategories(HardcodedData.categories, pattern)
    CategoriesScreen(
        categories = preview,
        onCategoryClick = {}
    )
}
