package com.example.mobile_programming.presentation.ui.screens.recipe_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.SubcomposeAsyncImage
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.TextPrimary
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.components.VerticalSpace
import com.example.mobile_programming.presentation.ui.screens.drink_details.components.DetailBadge
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe
import com.example.mobile_programming.presentation.view_model.recipes.RecipeUiState
import com.example.mobile_programming.presentation.view_model.recipes.RecipeViewModel

@Composable
fun RecipeDetailsScreen(
    recipeId: String,
    viewModel: RecipeViewModel,
    onBackClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(recipeId) {
        viewModel.loadRecipe(recipeId)
    }

    when (val state = uiState) {
        is RecipeUiState.Loading -> LoadingScreen()
        is RecipeUiState.Error -> ErrorScreen(
            message = state.message,
            onRetry = { viewModel.resetUiState() }
        )

        is RecipeUiState.Success -> {
            val currentRecipe = state.recipes.firstOrNull()
            RecipeDetailsScreen(
                recipe = currentRecipe,
                onBackClick = onBackClick
            )
        }

        else -> Unit
    }
}

@Composable
private fun RecipeDetailsScreen(
    recipe: Recipe?,
    onBackClick: () -> Unit
) {
    if (recipe == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Recipe not found.")
        }
    } else {
        Scaffold(
            topBar = {
                TopBar(onBackClick = onBackClick)
            },
            containerColor = WarmCream
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(dimensionResource(id = R.dimen.padding_16))
                    .verticalScroll(rememberScrollState())
            ) {
                SubcomposeAsyncImage(
                    model = recipe.imageUrl,
                    loading = {
                        Box(
                            Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) { CircularProgressIndicator(color = SunsetTangerine) }
                    },
                    error = {
                        Box(
                            Modifier
                                .background(Color.LightGray)
                                .fillMaxSize()
                        )
                    },
                    contentDescription = recipe.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.height_250))
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_12))),
                    contentScale = ContentScale.Crop
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_20))

                Text(
                    text = recipe.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary,
                    lineHeight = 28.sp
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_12))

                Row {
                    DetailBadge(text = "Ready in: ${recipe.cookingTime} mins")
                }

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                HorizontalDivider(
                    thickness = dimensionResource(R.dimen.thickness_half),
                    color = TextPrimary.copy(alpha = 0.1f)
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                Text(
                    text = "Ingredients",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_8))
                Text(
                    text = recipe.ingredients,
                    fontSize = 15.sp,
                    color = TextPrimary.copy(alpha = 0.8f),
                    lineHeight = 22.sp,
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                HorizontalDivider(
                    thickness = dimensionResource(R.dimen.thickness_half),
                    color = TextPrimary.copy(alpha = 0.1f)
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_20))
                Text(
                    text = "Instructions & Preparation",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                VerticalSpace(height = dimensionResource(R.dimen.height_8))
                Text(
                    text = recipe.instructions,
                    fontSize = 15.sp,
                    color = TextPrimary.copy(alpha = 0.7f),
                    lineHeight = 22.sp,
                )

                VerticalSpace(height = dimensionResource(id = R.dimen.height_24))
            }
        }
    }
}

@Preview(showBackground = true, name = "Detalji Recepta")
@Composable
fun RecipeDetailsPreview() {
    val sampleRecipe = Recipe(
        id = "1",
        name = "Grah sa suhim mesom",
        userId = "10",
        imageUrl = "https://example.com/grah.jpg",
        ingredients = "Grah, suho meso, mrkva, luk, zaprška, začini",
        instructions = "Grah potopiti preko noći. Kuhati sa suhim mesom i povrćem nekoliko sati. Na kraju dodati zapršku.",
        cookingTime = "120"
    )

    RecipeDetailsScreen(
        recipe = sampleRecipe,
        onBackClick = {}
    )
}