package com.fnine.pizzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fnine.pizzapp.screens.Cart
import com.fnine.pizzapp.screens.DetailPizza
import com.fnine.pizzapp.screens.PizzaMenu
import com.fnine.pizzapp.screens.WelcomeScreen
import com.fnine.pizzapp.ui.theme.PizzAppTheme
import com.fnine.pizzapp.viewModel.PizzaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel = remember { PizzaViewModel() }

            PizzAppTheme {
                Scaffold { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Navigation Host
                        NavHost(
                            navController = navController,
                            startDestination = "welcome",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("welcome") {
                                WelcomeScreen(
                                    onNavigateToMenu = { navController.navigate("pizza_menu") }
                                )
                            }
                            composable("pizza_menu") {
                                PizzaMenu(
                                    menu = viewModel.menu,
                                    onPizzaClick = { pizza ->
                                        navController.navigate("pizza_details/${pizza.name}")
                                    }
                                )
                            }
                            composable("pizza_details/{name}") { backStackEntry ->
                                val name = backStackEntry.arguments?.getString("name")
                                val pizza = viewModel.menu.find { it.name == name }
                                pizza?.let {
                                    DetailPizza(
                                        pizza = it,
                                        viewModel = viewModel,
                                        navController = navController
                                    )
                                }
                            }
                            composable("cart") {
                                Cart(
                                    cartItems = viewModel.cart,
                                    modifier = Modifier,
                                    onBackClick = { navController.navigate("pizza_menu") },
                                )
                            }
                        }

                        // Observe current destination
                        val currentBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = currentBackStackEntry?.destination?.route

                        // Show floating action button only on "pizza_menu"
                        if (currentDestination == "pizza_menu") {
                            FloatingActionButton(
                                onClick = { navController.navigate("cart") },
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .padding(16.dp)
                                    .size(56.dp),
                                shape = CircleShape,
                                containerColor = MaterialTheme.colorScheme.primary
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.ShoppingCart,
                                    contentDescription = "Go to Cart",
                                    tint = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzAppTheme {
        Greeting("you")
    }
}
