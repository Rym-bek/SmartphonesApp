package com.mechta.cache_models.converters.utils.list

interface ListConverterInterface<T> {
    fun toList(data: String): List<T>?
    fun toString(data: List<T>): String?
}