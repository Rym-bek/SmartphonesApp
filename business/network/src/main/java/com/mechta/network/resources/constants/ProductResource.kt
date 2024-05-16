package com.mechta.network.resources.constants

import com.mechta.network.resources.product.ProductConstants
import io.ktor.resources.Resource

@Resource(ProductConstants.PRODUCT)
class ProductResource {
    @Resource(CommonApiConstants.CODE_PATH)
    class GetProduct(
        val parent: ProductResource = ProductResource(),
        val code: String,
    )
}