package ru.barru.feature.authorization.navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import kotlinx.serialization.Serializable
import ru.barru.common_koin.ComponentFactory
import ru.barru.feature.authorization.createLoginComponent
import ru.barru.feature.authorization.createOtpComponent
import ru.barru.feature.authorization.presentation.login.LoginComponent
import ru.barru.feature.authorization.presentation.otp.OtpComponent
import ru.barru.navigation.BaseChild
import ru.barru.navigation.utils.toStateFlow

internal class AuthFlowComponentImpl(
    private val componentFactory: ComponentFactory,
    private val onAuthDone: () -> Unit,
    componentContext: ComponentContext
) : ComponentContext by componentContext, AuthFlowComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Login,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): Child = when (config) {

        is ChildConfig.Login -> {
            Child.Login(
                componentFactory.createLoginComponent(
                    componentContext = componentContext,
                    onDone = {
                        navigation.push(ChildConfig.Otp)
                    }
                )
            )
        }

        is ChildConfig.Otp -> {
            Child.Otp(
                componentFactory.createOtpComponent(
                    componentContext = componentContext,
                    onDone = onAuthDone
                )
            )
        }

    }

    @Composable
    override fun Content() = AuthFlowUi(this)
}

internal sealed interface Child : BaseChild {
    class Login(val component: LoginComponent) : Child
    class Otp(val component: OtpComponent) : Child
}

@Serializable
internal sealed interface ChildConfig {
    @Serializable
    data object Login : ChildConfig

    @Serializable
    data object Otp : ChildConfig
}
