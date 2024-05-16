package com.mechta.product_domain

import com.mechta.domain_models.asUi
import com.mechta.favorite_data.FavoriteLRI
import com.mechta.product_data.interfaces.ProductLRI
import com.mechta.ui_models.SmartphoneDetailsUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class ProductGLUC @Inject constructor(
    private val productLRI: ProductLRI,
    private val favoriteLRI: FavoriteLRI,
) {
    suspend operator fun invoke(
        code: String,
    ): Flow<SmartphoneDetailsUi> {

        return combine(
            productLRI.getProductLocal(code = code),
            favoriteLRI.getFavorites()
        ) { smartphoneDomain, favoriteList ->
            val isFavorite = favoriteList.any { it.id == smartphoneDomain.id }
            smartphoneDomain.asUi(isFavorite)
        }
    }

}