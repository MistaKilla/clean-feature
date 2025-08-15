package ru.barru.feature.product.presentation

import ru.barru.feature.product.presentation.model.ProductUi

sealed interface State {
    data object Loading : State
    data class Data(
        val productUi: ProductUi
    ) : State
}
