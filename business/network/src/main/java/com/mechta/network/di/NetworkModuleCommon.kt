package com.mechta.network.di

import com.mechta.network.api.catalog.CatalogAI
import com.mechta.network.api.catalog.CatalogApi
import com.mechta.network.api.product.ProductAI
import com.mechta.network.api.product.ProductApi
import com.mechta.network.utils.client.ktorHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModuleCommon {
    @Singleton
    @Provides
    fun provideKtorHttpClient(): HttpClient {
        return ktorHttpClient()
    }

    @Provides
    @Singleton
    fun provideCatalogApi(
        ktorHttpClient: HttpClient,
    ) : CatalogAI {
        return CatalogApi(ktorHttpClient)
    }

    @Provides
    @Singleton
    fun provideProductApi(
        ktorHttpClient: HttpClient,
    ) : ProductAI {
        return ProductApi(ktorHttpClient)
    }
}
