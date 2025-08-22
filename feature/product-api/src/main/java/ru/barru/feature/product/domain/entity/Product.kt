package ru.barru.feature.product.domain.entity

data class Product(
    val id: ProductId,
    val title: String,
    val subTitle: String,
    val isFavorite: Boolean
)
