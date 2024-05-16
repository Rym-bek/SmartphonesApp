package com.mechta.catalog_data

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.mechta.cache_models.SmartphoneEntity
import com.mechta.cache_models.asCache
import com.mechta.cache_models.common.RemoteKeysEntity
import com.mechta.common.enums.PaginationTypes
import com.mechta.database.AppDatabase
import com.mechta.database.dao.RemoteKeysDao
import com.mechta.database.dao.SmartphoneDao
import com.mechta.network.api.catalog.CatalogAI
import com.mechta.network.utils.result.NetworkResult
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

@OptIn(ExperimentalPagingApi::class)
class CatalogRemoteMediator(
    private val appDatabase: AppDatabase,
    private val remoteKeysDao: RemoteKeysDao,
    private val smartphoneDao: SmartphoneDao,
    private val catalogAI: CatalogAI,
    private val section: String,
): RemoteMediator<Int, SmartphoneEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, SmartphoneEntity>
    ): MediatorResult {
        val page: Int = when(loadType) {

            LoadType.REFRESH -> {
                val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                remoteKeys?.nextKey?.minus(1) ?: STARTING_PAGE_INDEX
            }
            LoadType.PREPEND -> {
                val remoteKeys = getRemoteKeyForFirstItem(state)
                val prevKey = remoteKeys?.prevKey
                prevKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
            LoadType.APPEND -> {
                val remoteKeys = getRemoteKeyForLastItem(state)
                val nextKey = remoteKeys?.nextKey
                nextKey ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
            }
        }

        try {
            val networkResult = catalogAI.getCatalog(
                page = page,
                pageSize = state.config.pageSize,
                section = section,
            )

            when (networkResult) {
                is NetworkResult.Success -> {
                    Log.d("OrganizationRemoteMediator", "Success ${networkResult.data}")
                    val catalog = networkResult.data.smartphoneDataRemote.smartphoneItemRemote
                    val endOfPaginationReached = catalog.isEmpty()

                    appDatabase.withTransaction {
                        if (loadType == LoadType.REFRESH) {
                            remoteKeysDao.clearRemoteKeys(PaginationTypes.CATALOG)

                            smartphoneDao.deleteSmartphones()
                        }

                        val prevKey = if (page > 1) page - 1 else null
                        val nextKey = if (endOfPaginationReached) null else page + 1

                        val remoteKeys = catalog.map {
                            RemoteKeysEntity(
                                organizationId = it.id,
                                prevKey = prevKey,
                                currentPage = page,
                                nextKey = nextKey,
                                type = PaginationTypes.CATALOG,
                            )
                        }

                        remoteKeysDao.upsert(remoteKeys)

                        smartphoneDao.upsert(catalog.asCache())
                    }
                    return MediatorResult.Success(
                        endOfPaginationReached = endOfPaginationReached
                    )
                }
                is NetworkResult.Error.HttpError -> {
                    Log.d("OrganizationRemoteMediator", "HttpError ${networkResult.errorMessage}")
                    return MediatorResult.Error(throwable = Throwable(
                        message = networkResult.errorMessage
                    ))
                }
                is NetworkResult.Error.SerializationError -> {
                    Log.d("OrganizationRemoteMediator", "SerializationError ${networkResult.errorMessage}")
                    return MediatorResult.Error(throwable = Throwable(
                        message = networkResult.errorMessage
                    ))
                }
                is NetworkResult.Error.GenericError -> {
                    Log.d("OrganizationRemoteMediator", "GenericError ${networkResult.errorMessage}")
                    return MediatorResult.Error(throwable = Throwable(
                        message = networkResult.errorMessage
                    ))
                }
            }
        } catch(e: IOException) {
            return MediatorResult.Error(e)
        }
    }


    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, SmartphoneEntity>
    ): RemoteKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                remoteKeysDao.getRemoteKey(
                    organizationId = id,
                    type = PaginationTypes.CATALOG,
                )
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, SmartphoneEntity>,
    ): RemoteKeysEntity? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { organization ->
            remoteKeysDao.getRemoteKey(
                organizationId = organization.id,
                type = PaginationTypes.CATALOG,
            )
        }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, SmartphoneEntity>,
    ): RemoteKeysEntity? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { organization ->
            remoteKeysDao.getRemoteKey(
                organizationId = organization.id,
                type = PaginationTypes.CATALOG,
            )
        }
    }
}