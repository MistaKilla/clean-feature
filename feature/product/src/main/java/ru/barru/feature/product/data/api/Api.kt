package ru.barru.feature.product.data.api

import ru.barru.feature.product.data.model.ProductDTO
import ru.barru.feature.product.domain.entity.ProductId

/**
 * Retrofit based request here
 */
internal interface Api {
    suspend fun getProduct(id: ProductId): ProductDTO
}

internal class ApiImpl : Api {
    override suspend fun getProduct(id: ProductId) = ProductDTO(
        id = "123",
        name = "Fake product",
        description = "content of ${id.id} product",
        inFav = false
    )
}
