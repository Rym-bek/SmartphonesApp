package com.mechta.smartphone_details.viewmodel.events

sealed class SmartphoneDetailsEvent {
    data class AddFavorite(val id: Long) : SmartphoneDetailsEvent()
    data class DeleteFavorite(val id: Long) : SmartphoneDetailsEvent()
}