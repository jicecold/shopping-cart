package me.jicecold.shoppingcart.domain.entities

import java.util.UUID

data class Cart (
    val id: UUID? = UUID.randomUUID(),
    val items: Sequence<CartItem> = emptySequence()
) {
    val amount = items.sumOf { it.price * it.quantity }
}