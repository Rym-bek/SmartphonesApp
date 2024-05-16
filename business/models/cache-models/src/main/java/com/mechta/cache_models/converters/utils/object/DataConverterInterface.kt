package com.mechta.cache_models.converters.utils.`object`

interface DataConverterInterface<T> {
    fun toString(data: T): String?
    fun toData(data: String): T?
}