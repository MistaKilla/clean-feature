package ru.barru.feature.product.data.repository

import ru.barru.feature.product.data.datasource.NetworkDatasource
import ru.barru.feature.product.data.mapper.ProductDtoMapper
import ru.barru.feature.product.domain.entity.Product
import ru.barru.feature.product.domain.entity.ProductId
import ru.barru.feature.product.domain.repository.ProductRepository

internal class ProductRepositoryImpl(
    private val datasource: NetworkDatasource,
    private val mapper: ProductDtoMapper
) : ProductRepository {
    override suspend fun getProduct(id: ProductId): Product = datasource
        .getProduct(id)
        .let (mapper::fromDto)
}