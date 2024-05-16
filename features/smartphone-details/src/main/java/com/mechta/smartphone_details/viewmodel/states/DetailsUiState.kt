package com.mechta.smartphone_details.viewmodel.states

import com.mechta.ui_models.SmartphoneDetailsUi

sealed interface DetailsUiState {
    data object Error : DetailsUiState
    data object Loading : DetailsUiState
    data class Success(
        val smartphoneDetailsUi: SmartphoneDetailsUi
    ) : DetailsUiState
}