package com.example.harmonyharvest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harmonyharvest.ui.theme.BlackCK
import com.example.harmonyharvest.ui.theme.HarmonyHarvestTheme
import com.example.harmonyharvest.ui.theme.YellowCK

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarmonyHarvestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Change the status bar color
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(BlackCK),
        verticalArrangement = SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // Displaying image taking 65% of the screen
        Image(
            painter = painterResource(id = R.drawable.cfkmain),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.65f)
                .clip(MaterialTheme.shapes.medium)
        )

        // Welcome message
        Greeting("Welcome to Harmony Harvest!")

        // Button to navigate to the next page
        ExButton()
    }
}

@Composable
fun ExButton() {
    var context = LocalContext.current
    var intent = remember {
        Intent(context, MainActivity2::class.java)
    }
    ElevatedButton(
        onClick = {
            context.startActivity(intent)
        },
        colors = ButtonDefaults.buttonColors(YellowCK),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp)

    ) {
        Text("Next Page")
//            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
    }
}

@Composable
fun Greeting(message: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = "Here communities come together to share the abundance of good food and goodwill! Reduce food waste, combat food insecurity, and foster solidarity within your neighborhood",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    HarmonyHarvestTheme {
        MainScreen()
    }
}
