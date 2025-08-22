package ru.barru.feature.product.domain.entity

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class ProductId(val id: String)