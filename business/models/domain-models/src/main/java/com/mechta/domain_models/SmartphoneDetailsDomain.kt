package com.mechta.domain_models

import com.mechta.cache_models.SmartphoneDetailsEntity
import com.mechta.ui_models.SmartphoneDetailsUi


data class SmartphoneDetailsDomain(
    val id: Long,
    val title: String,
    val code: String,
    val price: Int,
    val photos: List<String>,
    val isFavorite: Boolean = false,
    val properties: List<SmartphoneDetailsPropertiesDomain>
)

fun SmartphoneDetailsDomain.asUi(
    isFavorite: Boolean,
): SmartphoneDetailsUi {
    return SmartphoneDetailsUi(
        id = id,
        title = title,
        code = code,
        price = price,
        photos = photos,
        isFavorite = isFavorite,
        properties = properties.map {
            it.asUi()
        }
    )
}

fun SmartphoneDetailsEntity?.asDomain(): SmartphoneDetailsDomain {
    return SmartphoneDetailsDomain(
        id = this?.id ?: 0L,
        title = this?.title ?: "",
        code = this?.code ?: "",
        price = this?.price ?: 0,
        photos = this?.photos ?: emptyList(),
        properties = this?.properties?.map {
            it.asDomain()
        } ?: emptyList()
    )
}