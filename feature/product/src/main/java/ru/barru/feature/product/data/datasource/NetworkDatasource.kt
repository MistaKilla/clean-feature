package ru.barru.feature.product.data.datasource

import ru.barru.feature.product.data.model.ProductDTO
import ru.barru.feature.product.domain.entity.ProductId

internal interface NetworkDatasource {
    suspend fun getProduct(id: ProductId): ProductDTO
}
