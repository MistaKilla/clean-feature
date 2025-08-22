package ru.barru.feature.product.presentation

import ru.barru.feature.product.presentation.model.ProductModel

sealed interface State {
    data object Loading : State
    data class Data(
        val productModel: ProductModel
    ) : State
}
