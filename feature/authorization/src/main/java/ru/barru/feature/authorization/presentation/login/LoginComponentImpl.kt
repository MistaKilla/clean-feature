package ru.barru.feature.authorization.presentation.login

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class LoginComponentImpl(
    val onDone : () -> Unit,
    componentContext: ComponentContext
) : ComponentContext by componentContext, LoginComponent {
    private val _state = MutableStateFlow(LoginState("", ""))

    override val state: StateFlow<LoginState>
        get() = _state

    override fun onPassChanged(pass: String) {
        _state.value = _state.value.copy(pass = pass)
    }

    override fun onLoginChanged(login: String) {
        _state.value = _state.value.copy(login = login)
    }

    override fun onSubmitClicked() {
        onDone()
    }
}