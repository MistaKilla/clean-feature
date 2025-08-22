package ru.barru.feature.product.presentation.mapper

import ru.barru.feature.product.presentation.model.ProductModel
import ru.barru.feature.product.domain.entity.Product

internal interface UiMapper {
    suspend fun toUi(product: Product): ProductModel
}