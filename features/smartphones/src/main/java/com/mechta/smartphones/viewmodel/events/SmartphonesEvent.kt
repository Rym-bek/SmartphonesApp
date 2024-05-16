package com.mechta.smartphones.viewmodel.events

sealed class SmartphonesEvent {
    data class AddFavorite(val id: Long) : SmartphonesEvent()
    data class DeleteFavorite(val id: Long) : SmartphonesEvent()
}