package com.example.harmonyharvest

import Notification
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.harmonyharvest.ui.theme.BlackCK
import com.example.harmonyharvest.ui.theme.HarmonyHarvestTheme
import com.example.harmonyharvest.ui.theme.YellowCK

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HarmonyHarvestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}
//@ExperimentalMaterial3Api
@Composable
fun MyBottomAppBar(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val isModalVisible = remember { mutableStateOf(false) }
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = BlackCK
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screens.Home.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Home) Color.White else YellowCK)
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(Screens.Search.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Search) Color.White else YellowCK)
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                    contentAlignment = Alignment.Center){
                    FloatingActionButton(onClick = { isModalVisible.value = true }) {
                        Toast.makeText(context,"open",Toast.LENGTH_LONG).show()
                    }
                    Icon(Icons.Default.Add, contentDescription = null, tint = YellowCK)
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.List
                        navigationController.navigate(Screens.Notification.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.List, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.List) Color.White else YellowCK)
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Person) Color.White else YellowCK)
                }

            }
        }
    ) {paddingValues ->
        NavHost(navController = navigationController, startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)){
            composable(Screens.Home.screen){ Home() }
            composable(Screens.Search.screen){ Search() }
            composable(Screens.Notification.screen){ Notification() }
            composable(Screens.Profile.screen){ Profile() }
        }
        // Modal Popup
        if (isModalVisible.value) {
            FoodModal(
                onClose = { isModalVisible.value = false },
                onAdd = { foodName, imageUrl ->
                    // Handle adding the food with the given name and image URL
                    Toast.makeText(context, "Adding $foodName with image $imageUrl", Toast.LENGTH_LONG).show()
                    isModalVisible.value = false
                }
            )
        }
    }
}
@Composable
fun FoodModal(
    onClose: () -> Unit,
    onAdd: (foodName: String, imageUrl: String) -> Unit
) {
    // You can design your modal UI here, including TextFields for food name and image URL
    // and buttons for adding and closing the modal.

    // For simplicity, I'll provide a basic example using AlertDialog
    AlertDialog(
        onDismissRequest = onClose,
        title = { Text("Add Food") },
        text = {
            Column  {
                // Add text fields for food name and image URL
                // ...

                // You can use TextField to get user input
                // ...

                // Example:
                Text("Food Name:")
                var foodName by remember { mutableStateOf("") }
                TextField(
                    value = foodName,
                    onValueChange = { foodName = it },
                    label = { Text("Enter food name") }
                )

                Text("Image URL:")
                var imageUrl by remember { mutableStateOf("") }
                TextField(
                    value = imageUrl,
                    onValueChange = { imageUrl = it },
                    label = { Text("Enter image URL") }
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                // Call the onAdd callback with the entered values
                val foodName = ""
                val imageUrl = ""
                onAdd(foodName, imageUrl)
            }) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onClose) {
                Text("Cancel")
            }
        }
    )
}