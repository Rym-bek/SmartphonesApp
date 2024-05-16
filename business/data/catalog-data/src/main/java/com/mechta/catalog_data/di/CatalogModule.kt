package com.mechta.catalog_data.di

import com.mechta.catalog_data.CatalogRepository
import com.mechta.catalog_data.interfaces.CatalogLRI
import com.mechta.catalog_data.interfaces.CatalogRRI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CatalogModule {
    @Binds
    internal abstract fun bindsCatalogLRI(
        catalogRepository: CatalogRepository
    ): CatalogLRI

    @Binds
    internal abstract fun bindsCatalogRRI(
        catalogRepository: CatalogRepository
    ): CatalogRRI
}