package com.example.mobile_programming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile_programming.ui.theme.MobileprogrammingTheme
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileprogrammingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WelcomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileprogrammingTheme {
        Greeting("Android")
    }
}

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier) {
        Text(text = "Welcome to Gric")
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            Toast.makeText(
                context,
                "Button clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Text("Šta ti se jede?")
        }
    }
}