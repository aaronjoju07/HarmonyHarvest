package com.example.harmonyharvest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableInferredTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.harmonyharvest.ui.theme.YellowCK

@Composable
fun Home() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Greeting on top
            Text(text = "Welcome to Harmony Harvest!", fontSize = 24.sp, color = YellowCK)

            // Spacer for some vertical space
            Spacer(modifier = Modifier.height(16.dp))

            // Search bar
            OutlinedTextField(
                value = "", // Pass the actual value here
                onValueChange = { /* Handle value change */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(text = "Search...",
                        color = Color.Gray)
                },
                textStyle = TextStyle.Default.copy(color = Color.Black),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
            )

            // Spacer for some vertical space
            Spacer(modifier = Modifier.height(16.dp))

            // Set of dishes
            LazyColumn {
                items(dishes) { dish ->
                    DishCard(dish)
//                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishCard(dish: Dish) {
    Card(
        modifier = Modifier
            .height(300.dp)
            .width(450.dp)
            .padding(16.dp),
        onClick = { /* Handle card click */ }
    ) {
        Column {
            Image(
                painter = painterResource(id = dish.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = MaterialTheme.shapes.medium),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.padding(12.dp)){
                Text(text = dish.title, fontSize = 18.sp, color = YellowCK)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = dish.description, fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}

data class Dish(val title: String, val description: String, val imageResourceId: Int)

val dishes = listOf(
//    Dish("Spaghetti Bolognese", "Delicious Italian pasta with meat sauce", R.drawable.spaghetti_bolognese),
    Dish("Margherita Pizza", "Classic pizza with tomato, mozzarella, and basil", R.drawable.margherita_pizza),
    Dish("Caesar Salad", "Healthy salad with lettuce, croutons, and Caesar dressing", R.drawable.caesar_salad)
    // Add more dishes as needed
)
