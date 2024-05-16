package com.mechta.catalog_data.interfaces

import androidx.paging.PagingData
import com.mechta.domain_models.SmartphoneDomain
import kotlinx.coroutines.flow.Flow

interface CatalogLRI {
    fun getCatalog(
        section: String,
    ): Flow<PagingData<SmartphoneDomain>>
}