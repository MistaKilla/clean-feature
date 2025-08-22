package ru.barru.feature.product

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.Dispatchers
import ru.barru.common_koin.ComponentFactory
import ru.barru.feature.product.domain.entity.ProductId
import org.koin.core.component.get
import org.koin.dsl.module
import ru.barru.feature.product.data.api.Api
import ru.barru.feature.product.data.api.ApiImpl
import ru.barru.feature.product.data.datasource.NetworkDatasource
import ru.barru.feature.product.data.datasource.NetworkDatasourceImpl
import ru.barru.feature.product.data.mapper.ProductDtoMapper
import ru.barru.feature.product.data.mapper.ProductDtoMapperImpl
import ru.barru.feature.product.data.repository.ProductRepositoryImpl
import ru.barru.feature.product.domain.repository.ProductRepository
import ru.barru.feature.product.domain.usecase.GetProductUseCase
import ru.barru.feature.product.domain.usecase.GetProductUseCaseImpl
import ru.barru.feature.product.navigation.ProductFlowComponentImpl
import ru.barru.feature.product.presentation.ProductComponent
import ru.barru.feature.product.presentation.ProductComponentImpl
import ru.barru.feature.product.presentation.ProductFlowComponent
import ru.barru.feature.product.presentation.mapper.UiMapper
import ru.barru.feature.product.presentation.mapper.UiMapperImpl

internal fun ComponentFactory.createProductComponent(
    productId: ProductId,
    componentContext: ComponentContext
): ProductComponent =
    ProductComponentImpl(
        productId = productId,
        getProduct = get(),
        mapper = get(),
        dispatchers = get(),
        componentContext
    )

internal val productModule = module {
    single<Api> { ApiImpl() }
    single<Dispatchers> { Dispatchers }
    single<UiMapper> { UiMapperImpl() }
    single<NetworkDatasource> { NetworkDatasourceImpl(get(), get()) }
    single<ProductDtoMapper> { ProductDtoMapperImpl() }
    single<ProductRepository> { ProductRepositoryImpl(get(), get()) }
    single<GetProductUseCase> { GetProductUseCaseImpl(get()) }
}

val productFlowModule = module {
    includes(productModule)
}

fun ComponentFactory.createProductFlowComponent(
    productId: ProductId,
    componentContext: ComponentContext
): ProductFlowComponent =
    ProductFlowComponentImpl(
        productId = productId,
        componentFactory = this,
        componentContext = componentContext
    )
