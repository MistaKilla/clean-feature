package ru.barru.product.navigation

import ru.barru.product.domain.entity.ProductId

interface ProductRouter {
    fun navigateToProduct(productId: ProductId)
}