package me.jicecold.shoppingcart.app.carts

import me.jicecold.shoppingcart.domain.entities.Cart
import me.jicecold.shoppingcart.domain.gateways.CartGateway
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CartMemoryRepository : CartGateway {

    private val data = mutableMapOf<UUID, Cart>()

    override fun save(cart: Cart): Cart {
        return if (cart.id != null) {
            data[cart.id!!] = cart
            cart
        } else {
            throw RuntimeException("Id can't be null")
        }
    }

    override fun listAll(): List<Cart> {
        return data.map { it.value }
    }

    override fun findById(id: UUID): Cart {
        return data[id] ?: throw RuntimeException("Object not found!")
    }
}