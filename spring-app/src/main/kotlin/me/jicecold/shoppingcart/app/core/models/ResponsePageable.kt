package me.jicecold.shoppingcart.app.core.models

import com.fasterxml.jackson.annotation.JsonPropertyOrder

const val PAGEABLE_LIMIT = 100
const val PAGEABLE_OFFSET = 0

@JsonPropertyOrder(value = ["resource", "data", "limit", "offset", "last", "count", "total"])
open class ResponsePageable<T>(
    val resource: String,
    open val data: List<T>,
    val limit: Int = PAGEABLE_LIMIT,
    val offset: Int = PAGEABLE_OFFSET,
    val last: Boolean = false,
    val count: Int = 0,
    val total: Long = 0
)