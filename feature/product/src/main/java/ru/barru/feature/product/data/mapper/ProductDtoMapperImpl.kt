package ru.barru.feature.product.data.mapper

import ru.barru.feature.product.data.model.ProductDTO
import ru.barru.feature.product.domain.entity.Product
import ru.barru.feature.product.domain.entity.ProductId

internal class ProductDtoMapperImpl : ProductDtoMapper {
    override fun fromDto(productDTO: ProductDTO) = productDTO.run {
        Product(
            id = ProductId(id),
            title = name,
            subTitle = description,
            isFavorite = inFav
        )
    }
}