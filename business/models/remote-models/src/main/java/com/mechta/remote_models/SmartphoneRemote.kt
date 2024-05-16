package com.mechta.remote_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SmartphoneRemote(
    @SerialName("data")
    val smartphoneDataRemote: SmartphoneDataRemote = SmartphoneDataRemote()
)