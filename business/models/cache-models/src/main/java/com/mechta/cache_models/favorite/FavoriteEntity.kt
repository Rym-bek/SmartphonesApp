package com.mechta.cache_models.favorite

import androidx.room.Entity

@Entity(
    tableName = "favorites",
    primaryKeys = ["id"],
)
data class FavoriteEntity(
    val id: Long
)