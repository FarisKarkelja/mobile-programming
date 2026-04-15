package com.example.mobile_programming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mobile_programming.presentation.navigation.NavGraph
import com.example.mobile_programming.presentation.navigation.Screen
import com.example.mobile_programming.presentation.navigation.bottomBar.BottomBarNavigationComponent
import com.example.mobile_programming.presentation.navigation.bottomBar.BottomBarNavigationItems
import com.example.mobile_programming.presentation.theme.MobileprogrammingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileprogrammingTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val showBottomBar = currentRoute in Screen.getBottomBarNavigationRoutes()

                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            val items = BottomBarNavigationItems.items
                            val selectedIndex = items.indexOfFirst { it.route == currentRoute }

                            BottomBarNavigationComponent(
                                items = items,
                                selectedItemIndex = if (selectedIndex != -1) selectedIndex else 0,
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

