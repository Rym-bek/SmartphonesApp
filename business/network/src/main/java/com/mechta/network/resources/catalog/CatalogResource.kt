package com.mechta.network.resources.catalog

import io.ktor.resources.Resource
import kotlinx.serialization.SerialName

@Resource(CatalogConstants.CATALOG)
class CatalogResource {
    @Resource("")
    class GetCatalog(
        val parent: CatalogResource = CatalogResource(),
        val page: Int,
        @SerialName("page_limit")
        val pageSize: Int,
        val section: String? = null,
    )
}
