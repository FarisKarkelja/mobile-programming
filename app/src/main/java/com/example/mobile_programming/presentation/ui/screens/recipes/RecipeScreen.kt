package com.example.mobile_programming.presentation.ui.screens.recipes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobile_programming.R
import com.example.mobile_programming.presentation.theme.SunsetTangerine
import com.example.mobile_programming.presentation.theme.WarmCream
import com.example.mobile_programming.presentation.theme.White
import com.example.mobile_programming.presentation.ui.components.TopBar
import com.example.mobile_programming.presentation.ui.screens.error.ErrorScreen
import com.example.mobile_programming.presentation.ui.screens.loading.LoadingScreen
import com.example.mobile_programming.presentation.ui.screens.recipe_details.components.RecipeActionDialog
import com.example.mobile_programming.presentation.ui.screens.recipe_details.components.RecipeRowItem
import com.example.mobile_programming.presentation.ui.screens.recipes.util.Recipe
import com.example.mobile_programming.presentation.view_model.recipes.RecipeUiState
import com.example.mobile_programming.presentation.view_model.recipes.RecipeViewModel

@Composable
fun RecipesScreen(
    viewModel: RecipeViewModel,
    onNavigateToDetails: (String) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var showAddModal by remember { mutableStateOf(false) }
    var recipeToEdit by remember { mutableStateOf<Recipe?>(null) }

    when (val state = uiState) {
        is RecipeUiState.Loading -> LoadingScreen()
        is RecipeUiState.Error -> ErrorScreen(
            message = state.message,
            onRetry = { viewModel.resetUiState() }
        )

        is RecipeUiState.Success -> {
            RecipesScreen(
                recipes = state.recipes,
                onViewClick = { onNavigateToDetails(it.id) },
                onEditClick = { recipeToEdit = it },
                onDeleteClick = { viewModel.deleteRecipe(it.id) },
                onAddClick = { showAddModal = true }
            )
        }

        else -> Unit
    }

    if (showAddModal) {
        RecipeActionDialog(
            title = "Add New Recipe",
            onDismiss = { showAddModal = false },
            onConfirm = { name, ing, inst, time ->
                viewModel.insertRecipe(name, ing, inst, time)
                showAddModal = false
            }
        )
    }

    recipeToEdit?.let { recipe ->
        RecipeActionDialog(
            title = "Edit Recipe",
            initialName = recipe.name,
            initialIngredients = recipe.ingredients,
            initialInstructions = recipe.instructions,
            initialCookingTime = recipe.cookingTime,
            onDismiss = { recipeToEdit = null },
            onConfirm = { name, ing, inst, time ->
                viewModel.updateRecipe(recipe.id, name, ing, inst, time)
                recipeToEdit = null
            }
        )
    }
}

@Composable
private fun RecipesScreen(
    recipes: List<Recipe>,
    onViewClick: (Recipe) -> Unit,
    onEditClick: (Recipe) -> Unit,
    onDeleteClick: (Recipe) -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = { TopBar() },
        containerColor = WarmCream,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddClick,
                containerColor = SunsetTangerine,
                contentColor = White,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_12)),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Recipe",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    ) { paddingValues ->
        if (recipes.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No custom recipes found.", color = Color.Gray)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_16)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_8)),
                contentPadding = PaddingValues(bottom = 80.dp, top = 16.dp)
            ) {
                items(recipes) { recipe ->
                    RecipeRowItem(
                        recipe = recipe,
                        onViewClick = { onViewClick(recipe) },
                        onEditClick = { onEditClick(recipe) },
                        onDeleteClick = { onDeleteClick(recipe) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Glavni Ekran sa Receptima")
@Composable
fun RecipesScreenPreview() {
    val sampleRecipes = listOf(
        Recipe(
            id = "1",
            name = "Burek",
            userId = "10",
            ingredients = "Meso, luk, jufke, ulje, sol",
            instructions = "Razvući jufku, ispeći meso s lukom, umotati i peći na 200 stepeni.",
            cookingTime = "45"
        ),
        Recipe(
            id = "2",
            name = "Palačinke",
            userId = "10",
            ingredients = "Brašno, mlijeko, jaja, šećer, ulje",
            instructions = "Umutiti smjesu, peći na tavi, namazati eurokremom.",
            cookingTime = "15"
        )
    )

    RecipesScreen(
        recipes = sampleRecipes,
        onViewClick = {},
        onEditClick = {},
        onDeleteClick = {},
        onAddClick = {}
    )
}

@Preview(showBackground = true, name = "Prazan Ekran (Nema recepata)")
@Composable
fun RecipesScreenEmptyPreview() {
    RecipesScreen(
        recipes = emptyList(),
        onViewClick = {},
        onEditClick = {},
        onDeleteClick = {},
        onAddClick = {}
    )
}