package com.mechta.network.api.product

import com.mechta.network.resources.constants.ProductResource
import com.mechta.network.utils.base_api.BaseApi
import com.mechta.network.utils.result.NetworkResult
import com.mechta.remote_models.details.SmartphoneDetailsRemote
import io.ktor.client.HttpClient
import javax.inject.Inject

class ProductApi @Inject constructor(
    private val httpClient: HttpClient,
) : BaseApi(),
    ProductAI {
    override suspend fun getProduct(
        code: String,
    ): NetworkResult<SmartphoneDetailsRemote> {
        return httpClient.getData(
            ProductResource.GetProduct(
                code = code
            )
        )
    }
}