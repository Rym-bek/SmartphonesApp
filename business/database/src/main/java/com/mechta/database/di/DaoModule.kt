package com.mechta.database.di

import com.mechta.database.AppDatabase
import com.mechta.database.dao.RemoteKeysDao
import com.mechta.database.dao.SmartphoneDao
import com.mechta.database.dao.favorite.FavoriteDao
import com.mechta.database.dao.product.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {
    @Provides
    fun providesRemoteKeysDao(
        database: AppDatabase,
    ): RemoteKeysDao = database.remoteKeysDao()

    @Provides
    fun providesFavoriteDao(
        database: AppDatabase,
    ): FavoriteDao = database.favoriteDao()

    @Provides
    fun providesSmartphoneDao(
        database: AppDatabase,
    ): SmartphoneDao = database.smartphoneDao()

    @Provides
    fun providesProductDao(
        database: AppDatabase,
    ): ProductDao = database.productDao()
}
