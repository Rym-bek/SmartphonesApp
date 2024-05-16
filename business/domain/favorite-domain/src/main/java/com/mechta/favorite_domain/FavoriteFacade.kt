package com.mechta.favorite_domain

import com.mechta.domain_models.FavoriteDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteFacade @Inject constructor(
    private val favoriteALUC: FavoriteALUC,
    private val favoriteDLUC: FavoriteDLUC,
    private val favoritesGLUC: FavoritesGLUC,
) {
    suspend fun addFavorite(id: Long) {
        favoriteALUC(id)
    }

    suspend fun deleteFavorite(id: Long) {
        favoriteDLUC(id)
    }

    fun getFavorites(): Flow<List<FavoriteDomain>> {
        return favoritesGLUC()
    }
}