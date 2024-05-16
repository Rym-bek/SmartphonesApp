package com.mechta.remote_models.details

import com.mechta.remote_models.PropertiesRemote
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SmartphoneDetailsDataRemote(
    val id: Long = 0L,
    val title: String = "",
    val code: String = "",
    val price: Int = 0,
    val photos: List<String> = emptyList(),
    @SerialName("main_properties")
    val properties: List<PropertiesRemote> = emptyList(),
)