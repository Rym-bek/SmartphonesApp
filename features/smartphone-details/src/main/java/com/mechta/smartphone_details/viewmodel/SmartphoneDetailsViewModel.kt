package com.mechta.smartphone_details.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.mechta.common.utils.BaseViewModel
import com.mechta.common.utils.Result
import com.mechta.common.utils.asResult
import com.mechta.favorite_domain.FavoriteFacade
import com.mechta.product_domain.ProductFacade
import com.mechta.smartphone_details.navigation.SmartphoneDetailsArgs
import com.mechta.smartphone_details.viewmodel.events.SmartphoneDetailsEvent
import com.mechta.smartphone_details.viewmodel.states.DetailsUiState
import com.mechta.smartphone_details.viewmodel.states.SmartphoneDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SmartphoneDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val productFacade: ProductFacade,
    private val favoriteFacade: FavoriteFacade,
) : BaseViewModel<SmartphoneDetailsUiState, SmartphoneDetailsEvent>(SmartphoneDetailsUiState())
{
    private val code = SmartphoneDetailsArgs(savedStateHandle).code

    override fun onEvent(event: SmartphoneDetailsEvent) {
        when(event) {
            is SmartphoneDetailsEvent.AddFavorite -> {
                addFavorite(id = event.id)
            }
            is SmartphoneDetailsEvent.DeleteFavorite -> {
                deleteFavorite(id = event.id)
            }
        }
    }

    init {
        getProductLocal()

        getProductRemote()
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

    private fun getProductRemote() {
        viewModelScopeCustom {
            productFacade.getProductRemote(code = code)
        }
    }

    private fun getProductLocal() {
        viewModelScopeCustom {
            productFacade
                .getProductLocal(code = code)
                .asResult()
                .collect {

                    val detailsUiState = when (it) {
                        is Result.Success -> DetailsUiState.Success(smartphoneDetailsUi = it.data)
                        is Result.Loading -> DetailsUiState.Loading
                        is Result.Error -> DetailsUiState.Error
                    }

                    updateState {
                        copy(
                            detailsUiState = detailsUiState
                        )
                    }
                }
        }
    }
}