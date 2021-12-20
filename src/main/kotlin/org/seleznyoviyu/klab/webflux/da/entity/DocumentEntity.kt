package org.seleznyoviyu.klab.webflux.da.entity

data class DocumentEntity(
    val ulid: String,
    val title: String,
    val name: String,
    val document: Map<String, Any>
)
