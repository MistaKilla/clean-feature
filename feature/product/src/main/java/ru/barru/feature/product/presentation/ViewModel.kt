package ru.barru.feature.product.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.barru.feature.product.domain.usecase.GetProductUseCase
import ru.barru.feature.product.presentation.mapper.UiMapper
import ru.barru.product.domain.entity.ProductId

internal class ViewModel(
    private val productId: ProductId,
    private val getProduct: GetProductUseCase,
    private val mapper: UiMapper,
    private val dispatchers: Dispatchers
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Loading)
    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            val productUi = withContext(dispatchers.Default) {
                mapper.toUi(getProduct(productId))
            }
            _state.value = State.Data(productUi = productUi)
        }
    }
}