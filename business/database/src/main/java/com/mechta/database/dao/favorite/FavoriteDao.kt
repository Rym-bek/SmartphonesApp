package com.mechta.database.dao.favorite

import androidx.room.Dao
import androidx.room.Query
import com.korem.database.dao.base.BaseDao
import com.mechta.cache_models.favorite.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao: BaseDao<FavoriteEntity> {
    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): Flow<List<FavoriteEntity>>
}