package com.fnine.pizzapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fnine.pizzapp.model.Pizza
import com.fnine.pizzapp.ui.theme.PizzAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart(cartItems: List<Pair<Pizza, Int>>, modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    val total = cartItems.sumOf { it.first.price * it.second }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Cart") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                items(cartItems) { (pizza, quantity) ->
                    CartItem(pizza = pizza, quantity = quantity)
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                    TotalSection(total = total)
                }
            }
        }
    )
}

@Composable
fun CartItem(pizza: Pizza, quantity: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = pizza.name, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Quantity: $quantity", style = MaterialTheme.typography.bodyMedium)
            val price = pizza.price * quantity
            Text(text = "Price: ${price} Dh", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun TotalSection(total: Double) {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(text = "Total: ${"%.2f".format(total)} Dh", style = MaterialTheme.typography.headlineLarge, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Checkout", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCart() {
    PizzAppTheme {
        Cart(
            cartItems = listOf(
            ),
            onBackClick = {}
        )
    }
}
