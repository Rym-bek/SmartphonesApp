package com.mechta.catalog_domain

import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.mechta.catalog_data.interfaces.CatalogLRI
import com.mechta.domain_models.asUi
import com.mechta.favorite_data.FavoriteLRI
import com.mechta.ui_models.SmartphoneUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class CatalogGUC @Inject constructor(
    private val catalogLRI: CatalogLRI,
    private val favoriteLRI: FavoriteLRI,
) {
    operator fun invoke(
        section: String,
        scope: CoroutineScope,
    ): Flow<PagingData<SmartphoneUi>> {
        return combine(
            catalogLRI.getCatalog(section = section).cachedIn(scope),
            favoriteLRI.getFavorites(),
        ) { catalogData, favoritesData ->
            catalogData.map { catalogItem ->
                val isFavorite = favoritesData.any { it.id == catalogItem.id }
                catalogItem.asUi(isFavorite = isFavorite)
            }
        }
    }
}