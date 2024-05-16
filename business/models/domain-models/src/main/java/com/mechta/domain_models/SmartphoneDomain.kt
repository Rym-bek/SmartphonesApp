package com.mechta.domain_models

import com.mechta.cache_models.SmartphoneEntity
import com.mechta.ui_models.SmartphoneUi

data class SmartphoneDomain(
    val id: Long,
    val title: String,
    val code: String,
    val price: Int,
    val photos: List<String>,
    val isFavorite: Boolean = false,
)

fun SmartphoneDomain.asUi(
    isFavorite: Boolean,
): SmartphoneUi {
    return SmartphoneUi(
        id = id,
        title = title,
        code = code,
        price = price,
        photos = photos,
        isFavorite = isFavorite,
    )
}

fun SmartphoneEntity.asDomain(): SmartphoneDomain {
    return SmartphoneDomain(
        id = id,
        title = title,
        code = code,
        price = price,
        photos = photos,
    )
}