package com.mechta.product_data

import android.util.Log
import com.mechta.cache_models.asCache
import com.mechta.database.dao.product.ProductDao
import com.mechta.domain_models.SmartphoneDetailsDomain
import com.mechta.domain_models.asDomain
import com.mechta.network.api.product.ProductAI
import com.mechta.network.utils.result.NetworkResult
import com.mechta.product_data.interfaces.ProductLRI
import com.mechta.product_data.interfaces.ProductRRI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productAI: ProductAI,
    private val productDao: ProductDao,
) : ProductLRI,
    ProductRRI
{
    override suspend fun getProductLocal(
        code: String
    ): Flow<SmartphoneDetailsDomain> {
        Log.d("ProductRepository","${code}")
        return productDao
            .getSmartphone(code = code)
            .map {
                Log.d("ProductRepository","entity ${it}")
                it.asDomain()
            }
    }

    override suspend fun getProductRemote(
        code: String
    ) {
        val networkResult = productAI.getProduct(code = code)

        when (networkResult) {
            is NetworkResult.Success -> {
                productDao.upsert(
                    networkResult.data.smartphoneDetailsDataRemote.asCache()
                )
            }
            else -> {}
        }
    }
}