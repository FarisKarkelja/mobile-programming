package com.example.mobile_programming

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Scaffold(modifier = Modifier.fillMaxSize()) { padding ->

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    verticalArrangement = Arrangement.spacedBy(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text("Modifier Order: Background vs Padding")
                    BackgroundPaddingExample()

                    Text("Modifier Order: Clickable vs Padding")
                    ClickablePaddingExample()

                }

            }

        }
    }
}

//////////////////////////////////////////////////////////////
// 1️⃣ BACKGROUND vs PADDING
//////////////////////////////////////////////////////////////

@Composable
fun BackgroundPaddingExample() {

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {

        // Blue fills entire area
        Text(
            text = "background → padding",
            modifier = Modifier
                .background(Color.Blue)
                .padding(16.dp),
            color = Color.White
        )

        // Blue only inside padding
        Text(
            text = "padding → background",
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue),
            color = Color.White
        )

    }
}

//////////////////////////////////////////////////////////////
// 2️⃣ CLICKABLE vs PADDING
//////////////////////////////////////////////////////////////

@Composable
fun ClickablePaddingExample() {

    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {

        // Correct: clickable first (touch area bigger)
        Text(
            text = "Clickable BEFORE padding",
            modifier = Modifier
                .clickable {
                    Toast.makeText(context, "Large touch area", Toast.LENGTH_SHORT).show()
                }
                .background(Color.LightGray)
                .padding(16.dp)
        )

        // Wrong: clickable after padding (touch area smaller)
        Text(
            text = "Clickable AFTER padding",
            modifier = Modifier
                .padding(16.dp)
                .background(Color.LightGray)
                .clickable {
                    Toast.makeText(context, "Small touch area", Toast.LENGTH_SHORT).show()
                }
        )

    }
}

//////////////////////////////////////////////////////////////

@Preview(showBackground = true)
@Composable
fun ModifierOrderPreview() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BackgroundPaddingExample()
        ClickablePaddingExample()

    }

}


