package com.mechta.domain_models

import com.mechta.cache_models.favorite.FavoriteEntity

data class FavoriteDomain(
    val id: Long
)

fun List<FavoriteEntity>.asDomain(): List<FavoriteDomain> {
    return this.map { favoriteEntity: FavoriteEntity ->
        FavoriteDomain(
            id = favoriteEntity.id
        )
    }
}