package com.mechta.smartphones.viewmodel.states

sealed interface SmartphonesUiState {
    data object Loading : SmartphonesUiState

    data object Empty: SmartphonesUiState

    data object Error : SmartphonesUiState

    data object Success : SmartphonesUiState
}