package ru.barru.feature.product.presentation.mapper

import ru.barru.feature.product.presentation.model.ProductUi
import ru.barru.product.domain.entity.Product

interface UiMapper {
    suspend fun toUi(product: Product): ProductUi
}