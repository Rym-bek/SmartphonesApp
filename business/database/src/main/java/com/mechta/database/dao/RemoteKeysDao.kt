package com.mechta.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.korem.database.dao.base.BaseDao
import com.mechta.cache_models.common.RemoteKeysEntity
import com.mechta.common.enums.PaginationTypes

@Dao
interface RemoteKeysDao: BaseDao<RemoteKeysEntity> {
    @Query("SELECT * FROM remote_keys WHERE organization_id = :organizationId AND type = :type")
    suspend fun getRemoteKey(organizationId: Long, type: PaginationTypes): RemoteKeysEntity?

    @Query("DELETE FROM remote_keys WHERE type = :type")
    suspend fun clearRemoteKeys(type: PaginationTypes)

    @Query("SELECT created FROM remote_keys WHERE type = :type ORDER BY created DESC LIMIT 1")
    suspend fun getCreationTime(type: PaginationTypes): Long?
}