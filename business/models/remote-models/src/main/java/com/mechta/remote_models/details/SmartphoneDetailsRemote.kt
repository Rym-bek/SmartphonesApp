package com.mechta.remote_models.details

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SmartphoneDetailsRemote(
    @SerialName("data")
    val smartphoneDetailsDataRemote: SmartphoneDetailsDataRemote = SmartphoneDetailsDataRemote()
)