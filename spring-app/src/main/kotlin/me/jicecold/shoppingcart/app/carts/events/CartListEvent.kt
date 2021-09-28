package me.jicecold.shoppingcart.app.carts.events

import me.jicecold.shoppingcart.app.carts.events.CartAddItemEvent.Response
import me.jicecold.shoppingcart.app.core.models.ResponseList
import me.jicecold.shoppingcart.domain.entities.Cart
import me.jicecold.shoppingcart.domain.entities.CartItem
import java.util.UUID

object CartListEvent {

    fun convertFrom(list: List<Cart>) = ResponseWrapper(list.map { convertFrom(it) })

    fun convertFrom(cart: Cart) = Response(
        id = cart.id ?: UUID.randomUUID(),
        items = cart.items.toList(),
        amount = cart.amount
    )

    data class Response(
        val id: UUID,
        val items: List<CartItem> = listOf(),
        val amount: Long
    )

    data class ResponseWrapper(override val data: List<Response>) : ResponseList<Response>("carts", data)
}
