package com.mechta.cache_models.converters.utils.`object`

import androidx.room.TypeConverter
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

open class DataConverter<T>(
    private val serializer: KSerializer<T>,
    private val json: Json = Json {
        allowSpecialFloatingPointValues = true
    },
) : DataConverterInterface<T> {
    @TypeConverter
    override fun toString(data: T): String? {
        return json.encodeToString(
            serializer = serializer,
            value = data
        )
    }

    @TypeConverter
    override fun toData(data: String): T? {
        return json.decodeFromString(
            deserializer = serializer,
            string = data
        )
    }
}
