package me.jicecold.shoppingcart.app.core.models

open class ResponseList<T>(
    val resource: String,
    open val data: List<T>
)