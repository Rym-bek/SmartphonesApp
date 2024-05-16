package com.mechta.ui_models

data class SmartphoneDetailsUi(
    val id: Long,
    val title: String,
    val code: String,
    val price: Int,
    val photos: List<String>,
    val isFavorite: Boolean = false,
    val properties: List<SmartphoneDetailsPropertiesUi>
)