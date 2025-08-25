package ru.barru.feature.product.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.barru.feature.product.presentation.ProductUi

@Composable
internal fun ProductFlowUi(component: ProductFlowComponent) {
    val childStack by component.childStack.collectAsState()

    Children(childStack) { child ->
        when (val instance = child.instance) {
            is Child.Product -> ProductUi(instance.component)
        }
    }
}