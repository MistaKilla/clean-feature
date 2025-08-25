package ru.barru.feature.authorization.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.barru.feature.authorization.presentation.login.LoginUi
import ru.barru.feature.authorization.presentation.otp.OtpUi

@Composable
fun AuthFlowUi(component: AuthFlowComponent) {
    val childStack by component.childStack.collectAsState()

    Children(childStack) { child ->
        when (val instance = child.instance) {
            is Child.Login -> LoginUi(instance.component)
            is Child.Otp -> OtpUi(instance.component)
        }
    }
}