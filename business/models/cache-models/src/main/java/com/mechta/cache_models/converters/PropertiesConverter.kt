package com.mechta.cache_models.converters

import com.mechta.cache_models.PropertiesEntity
import com.mechta.cache_models.converters.utils.list.ListConverter

class PropertiesConverter
    : ListConverter<PropertiesEntity>(
    serializer = PropertiesEntity.serializer()
)