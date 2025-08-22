package ru.barru.feature.product.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import ru.barru.common_koin.ComponentFactory
import ru.barru.feature.product.domain.entity.ProductId
import ru.barru.feature.product.presentation.ProductComponent
import ru.barru.feature.product.presentation.ProductFlowComponent
import ru.barru.feature.product.createProductComponent
import ru.barru.navigation.BaseChild
import ru.barru.navigation.utils.toStateFlow

internal class ProductFlowComponentImpl(
    private val productId: ProductId,
    private val componentFactory: ComponentFactory,
    componentContext: ComponentContext
) : ComponentContext by componentContext, ProductFlowComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Product(productId),
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): Child = when (config) {

        is ChildConfig.Product -> {
            Child.Product(componentFactory.createProductComponent(
                productId = productId,
                componentContext = componentContext))
        }

    }

    @Composable
    override fun Content() = ProductFlowUi(this)
}

internal sealed interface Child: BaseChild {
    class Product(val component: ProductComponent) : Child
}

@Serializable
internal sealed interface ChildConfig {
    @Serializable
    data class Product(@Contextual val productId: ProductId) : ChildConfig
}
