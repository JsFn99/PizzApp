package com.fnine.pizzapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fnine.pizzapp.model.Pizza

data class CartItem(val pizza: Pizza, val quantity: Int, val price: Double)
{
    private val _cartItems = MutableLiveData<List<CartItem>>(emptyList())
    val cartItems: LiveData<List<CartItem>> get() = _cartItems

    fun addToCart(pizza: Pizza, quantity: Int) {
        val currentList = _cartItems.value.orEmpty().toMutableList()
        val price = pizza.price * quantity
        currentList.add(CartItem(pizza, quantity, price))
        _cartItems.value = currentList
    }

    fun calculateTotalPrice(): Double {
        return _cartItems.value.orEmpty().sumOf { it.price }
    }
}
