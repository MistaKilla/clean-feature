package ru.barru.feature.product.data.mapper

import ru.barru.feature.product.data.model.ProductDTO
import ru.barru.product.domain.entity.Product
import ru.barru.product.domain.entity.ProductId

internal class ProductDtoMapperImpl : ProductDtoMapper {
    override suspend fun fromDto(productDTO: ProductDTO) = productDTO.run {
        Product(
            id = ProductId(id),
            title = name,
            subTitle = description,
            isFavorite = inFav
        )
    }
}