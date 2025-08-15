package ru.barru.feature.product.domain.usecase

import ru.barru.product.domain.entity.Product
import ru.barru.product.domain.entity.ProductId

internal interface GetProductUseCase {
    suspend operator fun invoke(id: ProductId): Product
}