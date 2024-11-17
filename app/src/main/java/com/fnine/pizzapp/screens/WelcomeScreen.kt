package com.fnine.pizzapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fnine.pizzapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(onNavigateToMenu: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = "Bienvenue chez PizzApp!",
            style = MaterialTheme.typography.headlineLarge
        )
        Button(
            onClick = onNavigateToMenu,
            modifier = Modifier.padding(top = 16.dp).width(200.dp)
        ) {
            Text("Voir le menu")
        }
        Button(
            onClick = onNavigateToMenu,
            modifier = Modifier.padding(top = 16.dp).width(200.dp)
        ) {
            Text("Voir la Commande")
        }
        Button(
            onClick = onNavigateToMenu,
            modifier = Modifier.padding(top = 16.dp).width(200.dp)
        ) {
            Text("Payer la Commande")
        }
    }
}
