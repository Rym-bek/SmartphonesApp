package com.mechta.cache_models.common

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mechta.common.enums.PaginationTypes

@Entity(
    tableName = "remote_keys",
    primaryKeys = ["organization_id", "type"]
)
data class RemoteKeysEntity(
    @ColumnInfo(
        name = "organization_id",
    )
    val organizationId: Long,
    val prevKey: Int?,
    val currentPage: Int,
    val nextKey: Int?,
    val created: Long = System.currentTimeMillis(),
    val type: PaginationTypes,
)