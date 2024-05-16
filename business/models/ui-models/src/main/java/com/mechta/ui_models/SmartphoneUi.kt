package com.mechta.ui_models

data class SmartphoneUi(
    val id: Long,
    val title: String,
    val code: String,
    val price: Int,
    val photos: List<String>,
    val isFavorite: Boolean,
)