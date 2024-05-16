package com.mechta.cache_models

import com.mechta.remote_models.PropertiesRemote
import kotlinx.serialization.Serializable

@Serializable
data class PropertiesEntity(
    val id: Long,
    val name: String,
    val value: String,
)

fun PropertiesRemote.asCache(): PropertiesEntity {
    return PropertiesEntity(
        id = id,
        name = name,
        value = value,
    )
}