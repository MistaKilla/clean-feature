package ru.barru.feature.product.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.barru.feature.product.presentation.model.ProductModel
import ru.barru.navigation.utils.dispatchOnBackPressed

@Composable
internal fun ProductUi(
    productComponent: ProductComponent,
    modifier: Modifier = Modifier,
) {
    val state by productComponent.state.collectAsState()
    val context = LocalContext.current

    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.statusBars,
        topBar = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
            ) {
                IconButton(
                    onClick = { dispatchOnBackPressed(context) }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    ) { innerPadding ->
        DetailsContent(
            state = state,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}

@Composable
private fun DetailsContent(
    state: State,
    modifier: Modifier = Modifier,
) {
    when (state) {
        is State.Loading -> {
            CircularProgressIndicator()
        }

        is State.Data -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = state.productModel.firstString,
                )

                Text(
                    modifier = Modifier.padding(top = 32.dp),
                    text = state.productModel.secondString,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailsContent() {
    DetailsContent(
        state = State.Data(ProductModel("sdfs", "sdf"))
    )
}