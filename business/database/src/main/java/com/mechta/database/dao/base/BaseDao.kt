package com.korem.database.dao.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import androidx.room.Upsert

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: T): Long
 
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entities: List<T>): LongArray
 
    @Update
    fun update(entity: T)
 
    @Update
    fun update(entities: List<T>)

    @Upsert
    suspend fun upsert(entity: T)

    @Upsert
    suspend fun upsert(entities: List<T>)
 
    @Delete
    fun delete(entity: T)
 
    @Delete
    fun delete(entities: List<T>)
}