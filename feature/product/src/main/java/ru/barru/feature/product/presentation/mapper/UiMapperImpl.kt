package ru.barru.feature.product.presentation.mapper

import ru.barru.feature.product.domain.entity.Product
import ru.barru.feature.product.presentation.model.ProductModel

internal class UiMapperImpl : UiMapper{
    override suspend fun toUi(product: Product) = ProductModel(
        firstString = product.title,
        secondString = product.subTitle
    )
}