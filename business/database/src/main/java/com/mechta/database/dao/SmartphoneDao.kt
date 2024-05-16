package com.mechta.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.korem.database.dao.base.BaseDao
import com.mechta.cache_models.SmartphoneEntity

@Dao
interface SmartphoneDao: BaseDao<SmartphoneEntity> {
    @Query("SELECT * FROM smartphones")
    fun getSmartphones(): PagingSource<Int, SmartphoneEntity>

    @Query("DELETE FROM smartphones")
    suspend fun deleteSmartphones()
}