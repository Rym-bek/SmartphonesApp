package com.mechta.cache_models

import androidx.room.Entity
import com.mechta.remote_models.details.SmartphoneDetailsDataRemote

@Entity(
    tableName = "smartphone_details",
    primaryKeys = ["id"],
)
data class SmartphoneDetailsEntity(
    val id: Long,
    val title: String,
    val code: String,
    val price: Int,
    val photos: List<String>,
    val properties: List<PropertiesEntity>,
)

fun SmartphoneDetailsDataRemote.asCache(): SmartphoneDetailsEntity {
    return SmartphoneDetailsEntity(
            id = id,
            title = title,
            code = code,
            price = price,
            photos = photos,
            properties = properties.map {
                it.asCache()
            }
        )
}