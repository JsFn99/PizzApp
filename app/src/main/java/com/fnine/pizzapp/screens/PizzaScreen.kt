package com.fnine.pizzapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.fnine.pizzapp.model.Pizza
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fnine.pizzapp.R
import com.fnine.pizzapp.viewModel.PizzaViewModel
import com.google.ai.client.generativeai.type.content

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPizza(pizza: Pizza, viewModel: PizzaViewModel, navController: NavController, modifier: Modifier = Modifier) {
    var extraCheese by remember { mutableStateOf(50) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = pizza.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addToCart(pizza, 1) }) {
                Icon(imageVector = Icons.Filled.AddCircle, contentDescription = "Order")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = pizza.imageResourceId),
                contentDescription = pizza.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(400.dp)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = pizza.name, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Price: ${pizza.price} Dh", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Extra cheese: $extraCheese")
            Slider(
                value = extraCheese.toFloat(),
                onValueChange = { extraCheese = it.toInt() },
                valueRange = 0f..100f,
                steps = 4
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
