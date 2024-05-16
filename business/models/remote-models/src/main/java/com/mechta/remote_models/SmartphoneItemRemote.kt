package com.mechta.remote_models

import kotlinx.serialization.Serializable

@Serializable
data class SmartphoneItemRemote(
    val id: Long = 0L,
    val title: String = "",
    val code: String = "",
    val price: Int = 0,
    val photos: List<String> = emptyList(),
    val properties: List<PropertiesRemote> = emptyList(),
)
