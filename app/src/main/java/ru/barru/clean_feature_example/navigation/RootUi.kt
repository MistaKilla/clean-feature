package ru.barru.clean_feature_example.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children

@Composable
internal fun RootUi(component: RootComponent) {
    val childStack by component.childStack.collectAsState()

    Children(childStack) { child ->
        when (val instance = child.instance) {
            is Child.Authorization -> instance.component.Content()
            is Child.Product -> instance.component.Content()
        }
    }
}