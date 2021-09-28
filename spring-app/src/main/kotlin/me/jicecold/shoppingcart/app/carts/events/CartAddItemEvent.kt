package me.jicecold.shoppingcart.app.carts.events

import me.jicecold.shoppingcart.domain.entities.Cart
import me.jicecold.shoppingcart.domain.entities.CartItem
import java.util.UUID

object CartAddItemEvent {

    fun convertTo(request: Request) = CartItem(
        sku = request.sku,
        displayName = request.displayName,
        quantity = request.quantity,
        price = request.price
    )

    fun convertFrom(cart: Cart) = Response(
        id = cart.id ?: UUID.randomUUID(),
        items = cart.items.toList(),
        amount = cart.amount
    )

    data class Request(
        val sku: String,
        val displayName: String,
        val quantity: Int,
        val price: Long
    )

    data class Response(
        val id: UUID,
        val items: List<CartItem> = listOf(),
        val amount: Long
    )
}