package com.mechta.smartphones.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mechta.catalog_domain.CatalogGUC
import com.mechta.common.utils.BaseViewModel
import com.mechta.favorite_domain.FavoriteFacade
import com.mechta.smartphones.viewmodel.events.SmartphonesEvent
import com.mechta.smartphones.viewmodel.states.SmartphonesUiState
import com.mechta.ui_models.SmartphoneUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SmartphonesViewModel @Inject constructor(
    private val catalogGUC: CatalogGUC,
    private val favoriteFacade: FavoriteFacade,
) : BaseViewModel<SmartphonesUiState, SmartphonesEvent>(SmartphonesUiState.Success) {

    override fun onEvent(
        event: SmartphonesEvent,
    ) {
        when(event) {
            is SmartphonesEvent.AddFavorite -> {
                addFavorite(id = event.id)
            }
            is SmartphonesEvent.DeleteFavorite -> {
                deleteFavorite(id = event.id)
            }
        }
    }

    private fun addFavorite(
        id: Long
    ) {
        viewModelScopeCustom {
            favoriteFacade.addFavorite(id = id)
        }
    }

    private fun deleteFavorite(
        id: Long
    ) {
        viewModelScopeCustom {
            favoriteFacade.deleteFavorite(id = id)
        }
    }

    fun getSmartphones(): Flow<PagingData<SmartphoneUi>> {
        return catalogGUC(
            section = "smartfony",
            scope = viewModelScope
        ).cachedIn(viewModelScope)
    }
}