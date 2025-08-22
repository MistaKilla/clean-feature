package ru.barru.feature.product.data.mapper

import ru.barru.feature.product.data.model.ProductDTO
import ru.barru.feature.product.domain.entity.Product

internal interface ProductDtoMapper {
    // маппинг из дто в доменную модель
    fun fromDto(productDTO: ProductDTO): Product
}