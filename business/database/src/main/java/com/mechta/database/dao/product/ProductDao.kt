package com.mechta.database.dao.product

import androidx.room.Dao
import androidx.room.Query
import com.korem.database.dao.base.BaseDao
import com.mechta.cache_models.SmartphoneDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao: BaseDao<SmartphoneDetailsEntity> {
    @Query("SELECT * FROM smartphone_details where code = :code LIMIT 1")
    fun getSmartphone(
        code: String,
    ): Flow<SmartphoneDetailsEntity?>
}