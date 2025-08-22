package ru.barru.feature.product.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.barru.feature.product.data.api.Api
import ru.barru.feature.product.domain.entity.ProductId

internal class NetworkDatasourceImpl(
    private val api: Api,
    private val dispatchers: Dispatchers
) : NetworkDatasource {
    override suspend fun getProduct(id: ProductId) = withContext(dispatchers.IO) {
        api.getProduct(id)
    }

}