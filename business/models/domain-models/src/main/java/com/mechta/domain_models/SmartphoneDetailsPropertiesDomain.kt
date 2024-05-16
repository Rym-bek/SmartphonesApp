package com.mechta.domain_models

import com.mechta.cache_models.PropertiesEntity
import com.mechta.ui_models.SmartphoneDetailsPropertiesUi

data class SmartphoneDetailsPropertiesDomain(
    val name: String,
    val value: String,
)

fun PropertiesEntity?.asDomain(): SmartphoneDetailsPropertiesDomain{
    return SmartphoneDetailsPropertiesDomain(
        name = this?.name ?: "",
        value = this?.value ?: "",
    )
}

fun SmartphoneDetailsPropertiesDomain.asUi(): SmartphoneDetailsPropertiesUi{
    return SmartphoneDetailsPropertiesUi(
        name = name,
        value = value,
    )
}
