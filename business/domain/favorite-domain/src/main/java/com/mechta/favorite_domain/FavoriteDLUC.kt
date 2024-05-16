package com.mechta.favorite_domain

import com.mechta.favorite_data.FavoriteLRI
import javax.inject.Inject

class FavoriteDLUC @Inject constructor(
    private val favoriteLRI: FavoriteLRI
) {
    suspend operator fun invoke(id: Long) {
        favoriteLRI.deleteFavorite(id)
    }
}