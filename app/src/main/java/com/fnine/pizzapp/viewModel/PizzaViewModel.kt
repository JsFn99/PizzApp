package com.fnine.pizzapp.viewModel

import androidx.lifecycle.ViewModel
import com.fnine.pizzapp.R
import com.fnine.pizzapp.model.Pizza

class PizzaViewModel : ViewModel() {
    private val _menu = listOf(
        Pizza("Margherita", "Tomato sauce, mozzarella, and basil", R.drawable.margherita,45.0),
        Pizza("Pepperoni", "Tomato sauce, mozzarella, and pepperoni", R.drawable.pepperoni,50.0),
        Pizza("Vegetarian", "Tomato sauce, mozzarella, and a variety of vegetables", R.drawable.vegetarian,60.0),
        Pizza("Fromaggio", "Tomato sauce, mozzarella, and a variety of cheeses", R.drawable.fromaggio,65.0),
        Pizza("Burrata", "Tomato sauce, mozzarella, and burrata", R.drawable.burrata,70.0),
        Pizza("Diavola", "Tomato sauce, mozzarella, and salami", R.drawable.diavola,75.0),
        Pizza("Prosciutto", "Tomato sauce, mozzarella, and prosciutto", R.drawable.prosciutto,80.0),
        Pizza("Frutti di Mare", "Tomato sauce, mozzarella, and a variety of seafood", R.drawable.frutti_di_mare,85.0),
    )
    val menu: List<Pizza> = _menu

    private val _cart = mutableListOf<Pair<Pizza, Int>>()
    val cart: List<Pair<Pizza, Int>> get() = _cart

    fun addToCart(pizza: Pizza, quantity: Int) {
        val existing = _cart.find { it.first == pizza }
        if (existing != null) {
            _cart[_cart.indexOf(existing)] = existing.copy(second = existing.second + quantity)
        } else {
            _cart.add(pizza to quantity)
        }
    }
}
