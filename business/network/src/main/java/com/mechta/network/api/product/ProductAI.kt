package com.mechta.network.api.product

import com.mechta.network.utils.result.NetworkResult
import com.mechta.remote_models.details.SmartphoneDetailsRemote

interface ProductAI {
    suspend fun getProduct(
        code: String,
    ): NetworkResult<SmartphoneDetailsRemote>
}