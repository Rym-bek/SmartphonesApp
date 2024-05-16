package com.mechta.cache_models.converters.utils.list

import androidx.room.TypeConverter
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json


open class ListConverter<T>(
    private val serializer: KSerializer<T>,
    private val json: Json = Json {
        allowSpecialFloatingPointValues = true
    },
) : ListConverterInterface<T> {
    @TypeConverter
    override fun toList(data: String): List<T>? {
        return json.decodeFromString(ListSerializer(serializer), data)
    }

    @TypeConverter
    override fun toString(data: List<T>): String? {
        return json.encodeToString(ListSerializer(serializer), data)
    }
}



