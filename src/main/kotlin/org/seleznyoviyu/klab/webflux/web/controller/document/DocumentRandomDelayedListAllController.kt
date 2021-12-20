package org.seleznyoviyu.klab.webflux.web.controller.document

import org.seleznyoviyu.klab.webflux.domain.service.document.DocumentRandomDelayedListAllService
import org.seleznyoviyu.klab.webflux.web.json.document.DocumentJson
import org.seleznyoviyu.klab.webflux.web.mapper.document.DocumentJsonMapper
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class DocumentRandomDelayedListAllController(
    private val service: DocumentRandomDelayedListAllService,
    private val mapper: DocumentJsonMapper
) {

    @GetMapping("/document/random-delayed-list-all", produces = [MediaType.APPLICATION_NDJSON_VALUE])
    fun documentListAll(): Flux<DocumentJson> {
        return service.listAll().map(mapper::map)
    }
}