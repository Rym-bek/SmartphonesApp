package com.mechta.network.api.catalog

import com.mechta.network.utils.result.NetworkResult
import com.mechta.remote_models.SmartphoneRemote

interface CatalogAI {
    suspend fun getCatalog(
        page: Int,
        pageSize: Int,
        section: String,
    ): NetworkResult<SmartphoneRemote>
}