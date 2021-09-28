package me.jicecold.shoppingcart.domain.usecases

import me.jicecold.shoppingcart.domain.entities.Cart
import me.jicecold.shoppingcart.domain.gateways.CartGateway
import java.util.UUID

class CartReaderIterator(
    private val cartGateway: CartGateway
) {
    fun list(): List<Cart> = cartGateway.listAll()

    fun findOne(id: UUID): Cart = cartGateway.findById(id)
}