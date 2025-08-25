package ru.barru.feature.authorization.presentation.otp

import kotlinx.coroutines.flow.StateFlow

internal interface OtpComponent {
    val state: StateFlow<OtpState>

    fun onOtpChanged(otp: String)

    fun onSubmitClicked()
}