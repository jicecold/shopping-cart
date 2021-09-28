package me.jicecold.shoppingcart.domain.usecases

import me.jicecold.shoppingcart.domain.entities.Cart
import me.jicecold.shoppingcart.domain.entities.CartItem
import me.jicecold.shoppingcart.domain.gateways.CartGateway

class CartCreateIterator(
    private val cartGateway: CartGateway
) {

    fun execute(vararg items: CartItem): Cart {
        val cart = Cart(items = sequenceOf(*items))
        return cartGateway.save(cart)
    }
}