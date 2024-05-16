package com.mechta.catalog_data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.mechta.cache_models.SmartphoneEntity
import com.mechta.catalog_data.interfaces.CatalogLRI
import com.mechta.catalog_data.interfaces.CatalogRRI
import com.mechta.database.AppDatabase
import com.mechta.database.dao.RemoteKeysDao
import com.mechta.database.dao.SmartphoneDao
import com.mechta.domain_models.SmartphoneDomain
import com.mechta.domain_models.asDomain
import com.mechta.network.api.catalog.CatalogAI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CatalogRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    private val remoteKeysDao: RemoteKeysDao,
    private val smartphoneDao: SmartphoneDao,
    private val catalogAI: CatalogAI,
) : CatalogLRI,
    CatalogRRI
{
    @OptIn(ExperimentalPagingApi::class)
    override fun getCatalog(
        section: String,
    ): Flow<PagingData<SmartphoneDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 30,
            ),
            remoteMediator =
            CatalogRemoteMediator(
                appDatabase = appDatabase,
                remoteKeysDao = remoteKeysDao,
                smartphoneDao = smartphoneDao,
                catalogAI = catalogAI,
                section = section,
            )
            ,
            pagingSourceFactory = {
                smartphoneDao.getSmartphones()
            },
        ).flow.map {
            it.map { smartphoneEntity: SmartphoneEntity ->
                smartphoneEntity.asDomain()
            }
        }
    }
}