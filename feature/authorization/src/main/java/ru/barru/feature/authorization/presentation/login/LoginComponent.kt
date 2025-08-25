package ru.barru.feature.authorization.presentation.login

import kotlinx.coroutines.flow.StateFlow

internal interface LoginComponent {
    val state: StateFlow<LoginState>

    fun onLoginChanged(login: String)

    fun onPassChanged(pass: String)

    fun onSubmitClicked()
}