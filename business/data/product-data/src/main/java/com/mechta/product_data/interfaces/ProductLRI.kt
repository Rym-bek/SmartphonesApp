package com.mechta.product_data.interfaces

import com.mechta.domain_models.SmartphoneDetailsDomain
import kotlinx.coroutines.flow.Flow

interface ProductLRI {
    suspend fun getProductLocal(
        code: String,
    ): Flow<SmartphoneDetailsDomain>
}