package me.jicecold.shoppingcart.app.carts

import me.jicecold.shoppingcart.domain.gateways.CartGateway
import me.jicecold.shoppingcart.domain.usecases.CartCreateIterator
import me.jicecold.shoppingcart.domain.usecases.CartReaderIterator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CartConfiguration {

    @Bean
    fun cartCreateIterator(cartGateway: CartGateway) = CartCreateIterator(cartGateway)

    @Bean
    fun cartListAllIterator(cartGateway: CartGateway) = CartReaderIterator(cartGateway)
}