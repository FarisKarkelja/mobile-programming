package com.example.mobile_programming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mobile_programming.presentation.navigation.NavGraph
import com.example.mobile_programming.presentation.navigation.Screen
import com.example.mobile_programming.presentation.theme.MobileprogrammingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileprogrammingTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController();
                    NavGraph(
                        navController = navController,
                        startDestination = Screen.Login.route
                    )
                }
            }
        }
    }
}


