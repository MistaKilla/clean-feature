package ru.barru.feature.product.presentation

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.barru.feature.product.domain.entity.ProductId
import ru.barru.feature.product.domain.usecase.GetProductUseCase
import ru.barru.feature.product.presentation.mapper.UiMapper
import ru.barru.navigation.utils.componentScope

internal class ProductComponentImpl(
    productId: ProductId,
    private val getProduct: GetProductUseCase,
    private val mapper: UiMapper,
    private val dispatchers: Dispatchers,
    componentContext: ComponentContext
) : ComponentContext by componentContext, ProductComponent {
    override val state: StateFlow<State>
        get() = _state

    private val _state = MutableStateFlow<State>(State.Loading)

    init {
        componentScope.launch {
            val productUi = withContext(dispatchers.Default) {
                mapper.toUi(getProduct(productId))
            }
            _state.value = State.Data(productModel = productUi)
        }
    }
}