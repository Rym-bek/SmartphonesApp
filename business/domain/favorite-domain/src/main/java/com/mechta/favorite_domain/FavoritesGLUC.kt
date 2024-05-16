package com.mechta.favorite_domain

import com.mechta.domain_models.FavoriteDomain
import com.mechta.favorite_data.FavoriteLRI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesGLUC @Inject constructor(
    private val favoriteLRI: FavoriteLRI
) {
    operator fun invoke(): Flow<List<FavoriteDomain>> {
        return favoriteLRI.getFavorites()
    }
}