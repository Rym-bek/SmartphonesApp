package com.mechta.remote_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PropertiesRemote(
    @SerialName("prop_id")
    val id: Long,
    @SerialName("prop_name")
    val name: String,
    @SerialName("prop_value")
    val value: String,
)