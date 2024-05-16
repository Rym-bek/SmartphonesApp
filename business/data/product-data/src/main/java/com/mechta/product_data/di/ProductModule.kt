package com.mechta.product_data.di

import com.mechta.product_data.ProductRepository
import com.mechta.product_data.interfaces.ProductLRI
import com.mechta.product_data.interfaces.ProductRRI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductModule {
    @Binds
    internal abstract fun bindsProductLRI(
        productRepository: ProductRepository,
    ): ProductLRI

    @Binds
    internal abstract fun bindsProductRRI(
        productRepository: ProductRepository,
    ): ProductRRI
}