package ru.barru.clean_feature_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.retainedComponent
import ru.barru.clean_feature_example.ui.theme.CleanFeatureExampleTheme
import ru.barru.common_koin.ComponentFactory
import ru.barru.common_koin.koin
import ru.barru.feature.product.createProductFlowComponent
import ru.barru.feature.product.domain.entity.ProductId

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val rootComponent = retainedComponent { componentContext ->
            val componentFactory = application.koin.get<ComponentFactory>()
            componentFactory.createProductFlowComponent(
                productId = ProductId((Math.random() * 1000).toInt().toString()),
                componentContext)
        }
        setContent {
            CleanFeatureExampleTheme {
                rootComponent.Content()
            }
        }
    }
}
