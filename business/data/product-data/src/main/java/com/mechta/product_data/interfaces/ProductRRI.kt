package com.mechta.product_data.interfaces

interface ProductRRI {
    suspend fun getProductRemote(
        code: String,
    )
}