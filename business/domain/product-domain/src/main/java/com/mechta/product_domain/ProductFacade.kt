package com.mechta.product_domain

import com.mechta.ui_models.SmartphoneDetailsUi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductFacade @Inject constructor(
    private val productGLUC: ProductGLUC,
    private val productGRUC: ProductGRUC
) {
    suspend fun getProductRemote(
        code: String
    ) {
        productGRUC(code = code)
    }

    suspend fun getProductLocal(
        code: String
    ): Flow<SmartphoneDetailsUi> {
        return productGLUC(code = code)
    }
}