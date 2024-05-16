package com.mechta.network.api.catalog

import com.mechta.network.resources.catalog.CatalogResource
import com.mechta.network.utils.base_api.BaseApi
import com.mechta.network.utils.result.NetworkResult
import com.mechta.remote_models.SmartphoneRemote
import io.ktor.client.HttpClient
import javax.inject.Inject

class CatalogApi @Inject constructor(
    private val httpClient: HttpClient,
) : BaseApi(),
    CatalogAI
{
    override suspend fun getCatalog(
        page: Int,
        pageSize: Int,
        section: String,
    ): NetworkResult<SmartphoneRemote> {
        return httpClient.getData(
            CatalogResource.GetCatalog(
                page = page,
                pageSize = pageSize,
                section = section,
            )
        )
    }
}