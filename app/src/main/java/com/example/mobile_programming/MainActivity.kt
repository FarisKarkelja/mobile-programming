package com.example.mobile_programming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mobile_programming.model.datasource.local.util.DatabaseSeed
import com.example.mobile_programming.presentation.navigation.NavGraph
import com.example.mobile_programming.presentation.navigation.Screen
import com.example.mobile_programming.presentation.navigation.bottomBar.BottomBarNavigationComponent
import com.example.mobile_programming.presentation.navigation.bottomBar.BottomBarNavigationItems
import com.example.mobile_programming.presentation.theme.MobileprogrammingTheme
import com.example.mobile_programming.presentation.view_model.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var databaseSeed: DatabaseSeed
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            databaseSeed.seed()
        }
        setContent {
            MobileprogrammingTheme {
                val uiState by mainViewModel.uiState.collectAsStateWithLifecycle()

                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val showBottomBar =
                    currentRoute != null && Screen.getBottomBarNavigationRoutes().any { route ->
                        currentRoute == route || currentRoute.startsWith("$route/")
                    }

                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            val items = BottomBarNavigationItems.items
                            val selectedIndex = when {
                                currentRoute.startsWith("restaurants_screen") -> 0
                                currentRoute == Screen.FavoriteRestaurants.route -> 1
                                currentRoute == Screen.Recipes.route -> 2
                                currentRoute == Screen.Profile.route -> 3
                                else -> 0
                            }

                            BottomBarNavigationComponent(
                                items = items,
                                selectedItemIndex = selectedIndex,
                                onItemSelected = { index ->
                                    val destination = items[index].route

                                    navController.navigate(destination) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    Surface(modifier = Modifier.fillMaxSize()) {
                        NavGraph(
                            navController = navController,
                            startDestination = Screen.Login.route,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

