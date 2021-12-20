package org.seleznyoviyu.klab.webflux.domain.model.document

data class Document(
    val ulid: String,
    val title: String,
    val name: String,
    val document: Map<String, Any>
)