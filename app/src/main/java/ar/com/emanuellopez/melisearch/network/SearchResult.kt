package ar.com.emanuellopez.melisearch.network

import com.squareup.moshi.Json

data class SearchResult(
    @Json(name = "site_id") val siteId: String,
    val query: String,
    val paging: Paging,
    val results: List<Product>
)