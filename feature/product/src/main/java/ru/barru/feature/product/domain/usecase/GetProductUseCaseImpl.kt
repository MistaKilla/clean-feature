package ru.barru.feature.product.domain.usecase

import ru.barru.product.domain.entity.Product
import ru.barru.product.domain.entity.ProductId
import ru.barru.feature.product.domain.repository.ProductRepository

internal class GetProductUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductUseCase {
    override suspend fun invoke(id: ProductId): Product = productRepository.getProduct(id)
}