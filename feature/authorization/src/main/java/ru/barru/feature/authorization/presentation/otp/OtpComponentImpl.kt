package ru.barru.feature.authorization.presentation.otp

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class OtpComponentImpl(
    private val onDone: () -> Unit,
    componentContext: ComponentContext
) : ComponentContext by componentContext, OtpComponent {
    private val _state = MutableStateFlow(OtpState(""))

    override val state: StateFlow<OtpState>
        get() = _state

    override fun onOtpChanged(otp: String) {
        _state.value = _state.value.copy(code = otp)
    }

    override fun onSubmitClicked() {
        onDone()
    }
}