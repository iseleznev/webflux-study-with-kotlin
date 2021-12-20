package org.seleznyoviyu.klab.webflux.web.json.document

data class DocumentJson(
    val ulid: String,
    val title: String,
    val name: String,
    val document: Map<String, Any>
)
