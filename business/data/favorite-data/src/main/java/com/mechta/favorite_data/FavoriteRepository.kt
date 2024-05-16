package com.mechta.favorite_data

import com.mechta.cache_models.favorite.FavoriteEntity
import com.mechta.database.dao.favorite.FavoriteDao
import com.mechta.domain_models.FavoriteDomain
import com.mechta.domain_models.asDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepository @Inject constructor(
    private val favoriteDao: FavoriteDao,
) : FavoriteLRI {
    
    override suspend fun addFavorite(
        id: Long
    ) {
        favoriteDao.upsert(FavoriteEntity(id = id))
    }

    override suspend fun deleteFavorite(
        id: Long
    ) {
        favoriteDao.delete(FavoriteEntity(id = id))
    }

    override fun getFavorites(): Flow<List<FavoriteDomain>> {
        return favoriteDao
            .getAllFavorites()
            .map {
                it.asDomain()
            }
    }
}