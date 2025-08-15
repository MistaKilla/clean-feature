package ru.barru.feature.product.data.api

import ru.barru.feature.product.data.model.ProductDTO
import ru.barru.product.domain.entity.ProductId

/**
 * Retrofit based request here
 */
interface Api {
    suspend fun getProduct(id: ProductId): ProductDTO
}