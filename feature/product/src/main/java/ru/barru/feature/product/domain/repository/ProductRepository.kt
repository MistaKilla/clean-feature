package ru.barru.feature.product.domain.repository

import ru.barru.product.domain.entity.Product
import ru.barru.product.domain.entity.ProductId

internal interface ProductRepository {
    suspend fun getProduct(id: ProductId): Product
}