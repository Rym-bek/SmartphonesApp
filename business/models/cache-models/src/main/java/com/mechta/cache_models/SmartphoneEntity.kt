package com.mechta.cache_models

import androidx.room.Entity
import com.mechta.remote_models.SmartphoneItemRemote

@Entity(
    tableName = "smartphones",
    primaryKeys = ["id"],
)
data class SmartphoneEntity(
    val id: Long,
    val title: String,
    val code: String,
    val price: Int,
    val photos: List<String>,
)

fun List<SmartphoneItemRemote>.asCache(): List<SmartphoneEntity> {
    return this.map { smartphoneItemRemote: SmartphoneItemRemote ->
        SmartphoneEntity(
            id = smartphoneItemRemote.id,
            title = smartphoneItemRemote.title,
            code = smartphoneItemRemote.code,
            price = smartphoneItemRemote.price,
            photos = smartphoneItemRemote.photos,
        )
    }
}