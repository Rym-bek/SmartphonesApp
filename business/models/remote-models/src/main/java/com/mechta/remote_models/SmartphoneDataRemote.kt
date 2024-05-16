package com.mechta.remote_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SmartphoneDataRemote(

    @SerialName("page_number")
    val pageNumber: Int = 0,

    @SerialName("page_items_count")
    val pageSize: Int = 0,

    @SerialName("all_items_count")
    val pageSizeTotal: Int = 0,

    @SerialName("items")
    val smartphoneItemRemote: List<SmartphoneItemRemote> = emptyList(),
)