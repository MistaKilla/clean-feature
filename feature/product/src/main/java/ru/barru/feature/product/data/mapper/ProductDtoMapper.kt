package ru.barru.feature.product.data.mapper

import ru.barru.feature.product.data.model.ProductDTO
import ru.barru.product.domain.entity.Product

internal interface ProductDtoMapper {
    // маппинг из дто в доменную модель
    suspend fun fromDto(productDTO: ProductDTO): Product
}