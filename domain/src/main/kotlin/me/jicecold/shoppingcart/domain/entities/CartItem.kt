package me.jicecold.shoppingcart.domain.entities

import java.util.UUID

data class CartItem(
    val id: UUID? = UUID.randomUUID(),
    val sku: String,
    val displayName: String,
    val quantity: Int,
    val price: Long
)
