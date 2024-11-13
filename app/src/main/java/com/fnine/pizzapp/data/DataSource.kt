package com.fnine.pizzapp.data

import com.fnine.pizzapp.model.Pizza
import com.fnine.pizzapp.R

class DataSource {
    fun loadPizzas(): List<Pizza> {
        return listOf(
            Pizza("Margherita", "Tomato sauce, mozzarella, and basil", R.drawable.margherita,45.0),
            Pizza("Pepperoni", "Tomato sauce, mozzarella, and pepperoni", R.drawable.pepperoni,50.0),
            Pizza("Vegetarian", "Tomato sauce, mozzarella, and a variety of vegetables", R.drawable.vegetarian,60.0),
            Pizza("Fromaggio", "Tomato sauce, mozzarella, and a variety of cheeses", R.drawable.fromaggio,65.0),
            Pizza("Burrata", "Tomato sauce, mozzarella, and burrata", R.drawable.burrata,70.0),
            Pizza("Diavola", "Tomato sauce, mozzarella, and salami", R.drawable.diavola,75.0),
            Pizza("Prosciutto", "Tomato sauce, mozzarella, and prosciutto", R.drawable.prosciutto,80.0),
            Pizza("Frutti di Mare", "Tomato sauce, mozzarella, and a variety of seafood", R.drawable.frutti_di_mare,85.0),
            )
    }
}