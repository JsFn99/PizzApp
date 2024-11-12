package com.fnine.pizzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fnine.pizzapp.data.DataSource
import com.fnine.pizzapp.ui.theme.PizzAppTheme
import com.fnine.pizzapp.model.Pizza

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*PizzaCard(
                        pizza = Pizza("Regina", "Tomato sauce, mozzarella, and pepperoni", R.drawable.pepperoni),
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    PizzaMenu(
                        DataSource().loadPizzas(),
                        modifier = Modifier.padding(innerPadding)
                    )
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

@Composable
fun PizzaCard(pizza: Pizza, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        onClick = { /*TODO*/ }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = pizza.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )
            Text(
                text = pizza.name,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = pizza.description,
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun PizzaMenu(menu : List<Pizza>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(menu) { pizza -> PizzaCard(
            pizza = pizza,
            modifier = Modifier.padding(16.dp)
        )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzAppTheme {
        Greeting("nta")
    }
}