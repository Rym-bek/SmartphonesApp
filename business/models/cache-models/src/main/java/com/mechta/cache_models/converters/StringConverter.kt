package com.mechta.cache_models.converters

import com.mechta.cache_models.converters.utils.list.ListConverter
import kotlinx.serialization.builtins.serializer

class StringConverter
    : ListConverter<String>(
    serializer = String.serializer()
)