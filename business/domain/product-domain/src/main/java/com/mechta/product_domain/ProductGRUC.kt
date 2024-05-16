package com.mechta.product_domain

import com.mechta.product_data.interfaces.ProductRRI
import javax.inject.Inject

class ProductGRUC @Inject constructor(
    private val productRRI: ProductRRI,
) {
    suspend operator fun invoke(
        code: String,
    ) {
        productRRI.getProductRemote(code = code)
    }
}