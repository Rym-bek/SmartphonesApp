package com.mechta.favorite_data.di

import com.mechta.favorite_data.FavoriteLRI
import com.mechta.favorite_data.FavoriteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavoriteModule {
    @Binds
    internal abstract fun bindsFavoriteLRI(
        favoriteRepository: FavoriteRepository
    ): FavoriteLRI
}