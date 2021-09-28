package me.jicecold.shoppingcart.app.carts

import me.jicecold.shoppingcart.app.carts.events.CartAddItemEvent
import me.jicecold.shoppingcart.app.carts.events.CartListEvent
import me.jicecold.shoppingcart.domain.usecases.CartCreateIterator
import me.jicecold.shoppingcart.domain.usecases.CartReaderIterator
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.UUID

@RestController
@RequestMapping("/v1/carts")
class CartController(
    private val cartCreateIterator: CartCreateIterator,
    private val cartReaderIterator: CartReaderIterator
) {

    @PostMapping
    fun createCart(@RequestBody request: CartAddItemEvent.Request): Mono<ResponseEntity<CartAddItemEvent.Response>> =
        Mono.just(cartCreateIterator.execute(CartAddItemEvent.convertTo(request)))
            .map { ResponseEntity.status(CREATED).body(CartAddItemEvent.convertFrom(it)) }

    @GetMapping
    fun listAll(): Mono<ResponseEntity<CartListEvent.ResponseWrapper>> = Mono.just(cartReaderIterator.list())
        .map { ResponseEntity.ok(CartListEvent.convertFrom(it)) }

    @GetMapping("/{cartId}")
    fun findOne(@PathVariable(value = "cartId") cartId: UUID): Mono<ResponseEntity<CartListEvent.Response>> =
        Mono.just(cartReaderIterator.findOne(cartId))
            .map { ResponseEntity.ok(CartListEvent.convertFrom(it)) }

}