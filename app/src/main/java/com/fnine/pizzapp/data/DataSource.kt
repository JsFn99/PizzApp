package com.fnine.pizzapp.data

import com.fnine.pizzapp.model.Pizza
import com.fnine.pizzapp.R

class DataSource {
    fun loadPizzas(): List<Pizza> {
        return listOf(
            Pizza("Margherita", "Tomato sauce, mozzarella, and basil", R.drawable.margherita),
            Pizza("Pepperoni", "Tomato sauce, mozzarella, and pepperoni", R.drawable.pepperoni),
            Pizza("Vegetarian", "Tomato sauce, mozzarella, and a variety of vegetables", R.drawable.vegetarian),
            Pizza("Fromaggio", "Tomato sauce, mozzarella, and a variety of cheeses", R.drawable.fromaggio),
            Pizza("Burrata", "Tomato sauce, mozzarella, and burrata", R.drawable.burrata),
            Pizza("Diavola", "Tomato sauce, mozzarella, and salami", R.drawable.diavola),
            Pizza("Prosciutto", "Tomato sauce, mozzarella, and prosciutto", R.drawable.prosciutto),
            Pizza("Frutti di Mare", "Tomato sauce, mozzarella, and a variety of seafood", R.drawable.frutti_di_mare),
            )
    }
}