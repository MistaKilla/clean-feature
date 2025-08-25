package ru.barru.clean_feature_example

import com.arkivanov.decompose.ComponentContext
import ru.barru.clean_feature_example.navigation.RootComponent
import ru.barru.clean_feature_example.navigation.RootComponentImpl
import ru.barru.common_koin.ComponentFactory
import ru.barru.feature.authorization.authorizationFlowModule
import ru.barru.feature.product.productFlowModule

internal val modules = listOf(
    productFlowModule,
    authorizationFlowModule
)

internal fun ComponentFactory.createRootComponent(
    componentContext: ComponentContext
): RootComponent =
    RootComponentImpl(
        componentFactory = this,
        componentContext = componentContext
    )
