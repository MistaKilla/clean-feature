package ru.barru.clean_feature_example.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import kotlinx.serialization.Serializable
import ru.barru.common_koin.ComponentFactory
import ru.barru.feature.authorization.createAuthFlowComponent
import ru.barru.feature.authorization.navigation.AuthFlowComponent
import ru.barru.feature.product.createProductFlowComponent
import ru.barru.feature.product.domain.entity.ProductId
import ru.barru.feature.product.navigation.ProductFlowComponent
import ru.barru.navigation.BaseChild
import ru.barru.navigation.utils.toStateFlow

internal class RootComponentImpl(
    private val componentFactory: ComponentFactory,
    componentContext: ComponentContext
) : ComponentContext by componentContext, RootComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Authorization,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    @Composable
    override fun Content() = RootUi(this)

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): Child = when (config) {

        is ChildConfig.Authorization -> {
            Child.Authorization(
                componentFactory.createAuthFlowComponent(
                    componentContext,
                    onAuthDone = {
                        navigation.replaceAll(ChildConfig.Product)
                    }
                )
            )
        }

        is ChildConfig.Product -> {
            Child.Product(
                componentFactory.createProductFlowComponent(
                    productId = ProductId((Math.random() * 1000).toInt().toString()),
                    componentContext = componentContext
                )
            )
        }

    }

}

internal sealed interface Child : BaseChild {
    class Authorization(val component: AuthFlowComponent) : Child
    class Product(val component: ProductFlowComponent) : Child
}

@Serializable
internal sealed interface ChildConfig {

    @Serializable
    data object Authorization : ChildConfig

    @Serializable
    data object Product : ChildConfig

}
