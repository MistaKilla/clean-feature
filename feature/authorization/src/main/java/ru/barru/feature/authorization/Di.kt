package ru.barru.feature.authorization

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import ru.barru.common_koin.ComponentFactory
import ru.barru.feature.authorization.navigation.AuthFlowComponent
import ru.barru.feature.authorization.navigation.AuthFlowComponentImpl
import ru.barru.feature.authorization.presentation.login.LoginComponent
import ru.barru.feature.authorization.presentation.login.LoginComponentImpl
import ru.barru.feature.authorization.presentation.otp.OtpComponent
import ru.barru.feature.authorization.presentation.otp.OtpComponentImpl

internal fun ComponentFactory.createLoginComponent(
    componentContext: ComponentContext,
    onDone: () -> Unit
): LoginComponent =
    LoginComponentImpl(
        onDone = onDone,
        componentContext
    )

internal fun ComponentFactory.createOtpComponent(
    componentContext: ComponentContext,
    onDone: () -> Unit
): OtpComponent =
    OtpComponentImpl(
        onDone = onDone,
        componentContext
    )

internal val authModule = module {
    single<Dispatchers> { Dispatchers }
}

val authorizationFlowModule = module {
    includes(authModule)
}

fun ComponentFactory.createAuthFlowComponent(
    componentContext: ComponentContext,
    onAuthDone: () -> Unit
): AuthFlowComponent =
    AuthFlowComponentImpl(
        componentFactory = this,
        componentContext = componentContext,
        onAuthDone = onAuthDone
    )
