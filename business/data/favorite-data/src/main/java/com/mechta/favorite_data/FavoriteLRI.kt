package com.mechta.favorite_data

import com.mechta.domain_models.FavoriteDomain
import kotlinx.coroutines.flow.Flow

interface FavoriteLRI {
    
    suspend fun addFavorite(id: Long)
    suspend fun deleteFavorite(id: Long)
    fun getFavorites(): Flow<List<FavoriteDomain>>
}