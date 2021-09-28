package me.jicecold.shoppingcart.domain.gateways

import me.jicecold.shoppingcart.domain.entities.Cart
import java.util.UUID

interface CartGateway {

    fun save(cart: Cart): Cart

    fun listAll(): List<Cart>

    fun findById(id: UUID): Cart

}