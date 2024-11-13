package com.fnine.pizzapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fnine.pizzapp.model.Pizza

@Composable
fun PizzaCard(pizza: Pizza, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier,
        onClick = onClick
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
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = pizza.description,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "\$ ${pizza.price}",
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun PizzaMenu(menu: List<Pizza>, onPizzaClick: (Pizza) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(menu) { pizza ->
            PizzaCard(
                pizza = pizza,
                onClick = { onPizzaClick(pizza) },
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}


