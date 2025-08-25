package ru.barru.feature.authorization.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
internal fun LoginUi(
    component: LoginComponent,
    modifier: Modifier = Modifier
) {
    val state by component.state.collectAsState()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.statusBars,
        topBar = { }
    ) { innerPadding ->
        LoginContent(
            state = state,
            onSubmitClicked = component::onSubmitClicked,
            onLoginChanged = component::onLoginChanged,
            onPassChanged = component::onPassChanged,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
private fun LoginContent(
    state: LoginState,
    onSubmitClicked: () -> Unit,
    onLoginChanged: (String) -> Unit,
    onPassChanged: (String) -> Unit,
    modifier: Modifier = Modifier
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login")
        TextField(
            value = state.login,
            onValueChange = onLoginChanged
        )
        Text(text = "Password")
        TextField(
            value = state.pass,
            onValueChange = onPassChanged,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(onClick = { onSubmitClicked() }) {
            Text(text = "Submit")
        }
    }
}