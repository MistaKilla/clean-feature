package ru.barru.feature.product.presentation

import kotlinx.coroutines.flow.StateFlow

internal interface ProductComponent {
    val state: StateFlow<State>
}