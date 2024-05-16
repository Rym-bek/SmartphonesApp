package com.mechta.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mechta.cache_models.SmartphoneDetailsEntity
import com.mechta.cache_models.SmartphoneEntity
import com.mechta.cache_models.common.RemoteKeysEntity
import com.mechta.cache_models.converters.PropertiesConverter
import com.mechta.cache_models.converters.StringConverter
import com.mechta.cache_models.favorite.FavoriteEntity
import com.mechta.database.dao.RemoteKeysDao
import com.mechta.database.dao.SmartphoneDao
import com.mechta.database.dao.favorite.FavoriteDao
import com.mechta.database.dao.product.ProductDao

private const val DATABASE_VERSION = 1

@Database(
    entities = [
        RemoteKeysEntity::class,
        FavoriteEntity::class,

        SmartphoneEntity::class,
        SmartphoneDetailsEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = true,
)

@TypeConverters(
    StringConverter::class,
    PropertiesConverter::class,
)

abstract class AppDatabase : RoomDatabase() {
    //api dao
    abstract fun smartphoneDao(): SmartphoneDao
    abstract fun productDao(): ProductDao

    //business dao
    abstract fun remoteKeysDao(): RemoteKeysDao
    abstract fun favoriteDao(): FavoriteDao
}