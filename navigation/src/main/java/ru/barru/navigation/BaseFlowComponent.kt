package ru.barru.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.coroutines.flow.StateFlow

interface BaseFlowComponent {
    val childStack: StateFlow<ChildStack<*, BaseChild>>

    @Composable
    fun Content()
}